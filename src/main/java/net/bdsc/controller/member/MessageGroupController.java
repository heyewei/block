/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: zAB3ERi0AQXkPdwZnfwGjVoG10LqsVd7
 */
package net.bdsc.controller.member;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonView;

import net.bdsc.Pageable;
import net.bdsc.Results;
import net.bdsc.entity.BaseEntity;
import net.bdsc.entity.Member;
import net.bdsc.entity.MessageGroup;
import net.bdsc.exception.UnauthorizedException;
import net.bdsc.security.CurrentUser;
import net.bdsc.service.MessageGroupService;

/**
 * Controller - 会员中心 - 消息组
 * 
 * @author 好源++ Team
 * @version 6.1
 */
@Controller("memberMessageGroupController")
@RequestMapping("/member/message_group")
public class MessageGroupController extends BaseController {

	/**
	 * 每页记录数
	 */
	private static final int PAGE_SIZE = 10;

	@Inject
	private MessageGroupService messageGroupService;

	/**
	 * 添加属性
	 */
	@ModelAttribute
	public void populateModel(Long messageGroupId, @CurrentUser Member currentUser, ModelMap model) {
		MessageGroup messageGroup = messageGroupService.find(messageGroupId);
		if (messageGroup != null && !currentUser.equals(messageGroup.getUser1()) && !currentUser.equals(messageGroup.getUser2())) {
			throw new UnauthorizedException();
		}
		model.addAttribute("messageGroup", messageGroup);
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Integer pageNumber, @CurrentUser Member currentUser, Model model) {
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("page", messageGroupService.findPage(currentUser, pageable));
		return "member/message_group/list";
	}

	/**
	 * 列表
	 */
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(BaseEntity.BaseView.class)
	public ResponseEntity<?> list(Integer pageNumber, @CurrentUser Member currentUser) {
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		return ResponseEntity.ok(messageGroupService.findPage(currentUser, pageable).getContent());
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@ModelAttribute(binding = false) MessageGroup messageGroup, @CurrentUser Member currentUser) {
		if (messageGroup == null) {
			return Results.NOT_FOUND;
		}

		messageGroupService.delete(messageGroup, currentUser);
		return Results.OK;
	}

}