
package net.bdsc.service;

import net.bdsc.entity.BitCoinAccount;
import net.bdsc.entity.Member;

import java.util.List;

/**
 * Service - 广告
 * 
 * @author 好源++ Team
 * @version 6.1
 */
public interface BitCoinAccountService extends BaseService<BitCoinAccount, Long> {

    List<BitCoinAccount> findByUserId(Long userId);

    BitCoinAccount findByUserIdAndName(Long userId,String name);

    void initAccount(Member member);

}