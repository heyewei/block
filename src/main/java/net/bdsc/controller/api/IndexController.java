package net.bdsc.controller.api;

import com.fasterxml.jackson.core.type.TypeReference;
import net.bdsc.common.Result;
import net.bdsc.entity.Adversite;
import net.bdsc.entity.BitCoinType;
import net.bdsc.entity.MineMachine;
import net.bdsc.service.AdversiteService;
import net.bdsc.service.BitCoinTypeService;
import net.bdsc.service.MineMachineService;
import net.bdsc.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@RestController("iconApiIndexController")
@RequestMapping("/icon/api")
public class IndexController {

    @Autowired
    private BitCoinTypeService bitCoinTypeService;
    @Autowired
    private MineMachineService mineMachineService;
    @Autowired
    private AdversiteService adversiteService;

    @PostMapping
    public Result index (String url, String url1, String method, String params, String data, HttpServletRequest request){
        System.out.println("url:"+url);
        System.out.println("url1:"+url1);
        System.out.println("params:"+params);
        System.out.println("data:"+data);
        System.out.println("method:"+method);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++header++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+":"+request.getHeader(headerName));
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++header++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++cache++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            System.out.println(cookie.getName()+":"+cookie.getValue());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++cache++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("===================================================================================");

        return Result.success("",null);
    }

    @GetMapping("/init")
    public Result init (){
        List<String> icons = Arrays.asList("BTC","USDT","CNY","HBT","ETH");
        for (String icon:icons) {
            BitCoinType bitCoinType = new BitCoinType();
            bitCoinType.setEnabled(true);
            bitCoinType.setName(icon);
            bitCoinType.setPrice(BigDecimal.ONE);
            if(StringUtils.equalsIgnoreCase(icon,"BTC")){
                bitCoinType.setAssetType(1);;
            }else if(StringUtils.equalsIgnoreCase(icon,"USDT")){
                bitCoinType.setAssetType(2);;
            }else if(StringUtils.equalsIgnoreCase(icon,"CNY")){
                bitCoinType.setAssetType(3);;
            }else if(StringUtils.equalsIgnoreCase(icon,"HBT")){
                bitCoinType.setAssetType(4);;
            }else if(StringUtils.equalsIgnoreCase(icon,"ETH")){
                bitCoinType.setAssetType(5);;
            }

            bitCoinTypeService.save(bitCoinType);
        }
        return Result.success("ok");
    }

    @GetMapping("/init1")
    public Result init1 (){
        String str="[{\"createDate\":\"2020-09-30 18:51:55\",\"creator\":1,\"modifyDate\":\"2020-11-01 00:01:29\",\"modifier\":1,\"version\":0,\"id\":226,\"type\":5,\"name\":\"???BTC????????????????????????11???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-09-30/363757864730230784148804_2020-09-30.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":38.9,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":257.907,\"stock\":977181,\"isStock\":false,\"expirationDate\":\"2020-11-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":145,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-08-31 17:15:54\",\"creator\":1,\"modifyDate\":\"2020-10-01 00:02:37\",\"modifier\":1,\"version\":0,\"id\":223,\"type\":5,\"name\":\"???BTC????????????????????????10???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-08-31/352863616766050304433139_2020-08-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":39.9,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":264.537,\"stock\":495657,\"isStock\":false,\"expirationDate\":\"2020-10-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":189,\"investTime\":\"2020-10-01 00:00:00\",\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-08-31 16:59:26\",\"creator\":1,\"modifyDate\":\"2020-09-21 00:01:03\",\"modifier\":1,\"version\":0,\"id\":221,\"type\":5,\"name\":\"?????????????????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-08-31/352859628914081792453602_2020-08-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":50.9,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":337.467,\"stock\":499945,\"isStock\":false,\"expirationDate\":\"2020-10-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":239,\"investTime\":\"2020-10-01 00:00:00\",\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-07-31 16:39:49\",\"creator\":1,\"modifyDate\":\"2020-09-01 00:08:16\",\"modifier\":1,\"version\":0,\"id\":214,\"type\":5,\"name\":\"???BTC??????????????????-???9???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-07-31/341620393775202304027232_2020-07-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":36.9,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":244.647,\"stock\":990061,\"isStock\":false,\"expirationDate\":\"2020-09-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":189,\"investTime\":\"2020-09-01 00:00:00\",\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-07-22 13:59:00\",\"creator\":1,\"modifyDate\":\"2020-10-31 22:22:11\",\"modifier\":1,\"version\":0,\"id\":205,\"type\":5,\"name\":\"???BTC??????????????????-???8???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-07-22/338318148161765376395630_2020-07-22.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":32.8,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.65,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":217.464,\"stock\":96333,\"isStock\":false,\"expirationDate\":\"2020-08-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":189,\"investTime\":\"2020-08-01 00:00:00\",\"btcDiscount\":1,\"hbtDiscount\":1.5,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null}]";
        List<MineMachine> machines = JsonUtils.toObject(str, new TypeReference<List<MineMachine>>() {
        });
        for (MineMachine m:machines) {
            m.setId(null);
            mineMachineService.save(m);
        }
        str="[{\"createDate\":\"2020-11-11 22:28:40\",\"creator\":1,\"modifyDate\":\"2020-11-21 00:02:20\",\"modifier\":1,\"version\":0,\"id\":247,\"type\":1,\"name\":\"2020?????????????????????8???\",\"tag\":\"????????????,?????????,?????????\",\"icon\":\"/static/images/product/2020-11-11/379034284993806336914670_2020-11-11.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":271.16,\"price\":45.9,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0.43,\"electric\":0.065,\"electricDiscount\":0.7,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":304.317,\"stock\":994185,\"isStock\":false,\"expirationDate\":\"2020-12-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":188,\"investTime\":null,\"btcDiscount\":1,\"hbtDiscount\":1.2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-31 16:07:45\",\"creator\":1,\"modifyDate\":\"2020-11-01 00:01:12\",\"modifier\":1,\"version\":0,\"id\":237,\"type\":1,\"name\":\"BTC??????????????????11??????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-31/374951847691026432629764_2020-10-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":260.24,\"price\":38.9,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0.43,\"electric\":0.065,\"electricDiscount\":0.7,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":3,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":257.907,\"stock\":978912,\"isStock\":false,\"expirationDate\":\"2020-11-12 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":253,\"investTime\":null,\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-09-30 18:56:49\",\"creator\":1,\"modifyDate\":\"2020-10-01 00:01:14\",\"modifier\":1,\"version\":0,\"id\":227,\"type\":1,\"name\":\"2020?????????????????????7???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-09-30/363760795860860928701641_2020-09-30.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":42.5,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":281.775,\"stock\":993248,\"isStock\":false,\"expirationDate\":\"2020-11-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":188,\"investTime\":null,\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-08-31 17:12:57\",\"creator\":1,\"modifyDate\":\"2020-09-01 00:28:20\",\"modifier\":1,\"version\":0,\"id\":222,\"type\":1,\"name\":\"2020?????????????????????6???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-08-31/352862998903128064926136_2020-08-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":42.5,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":281.775,\"stock\":698990,\"isStock\":false,\"expirationDate\":\"2020-10-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":188,\"investTime\":null,\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-08-31 16:57:43\",\"creator\":1,\"modifyDate\":\"2020-09-01 00:04:35\",\"modifier\":1,\"version\":0,\"id\":220,\"type\":1,\"name\":\"?????????????????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-08-31/352859036258926592618323_2020-08-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":56.5,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.065,\"electricDiscount\":0.6,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":374.595,\"stock\":498664,\"isStock\":false,\"expirationDate\":\"2020-10-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":240,\"investTime\":null,\"btcDiscount\":1,\"hbtDiscount\":2,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null}]";
        machines = JsonUtils.toObject(str, new TypeReference<List<MineMachine>>() {
        });
        for (MineMachine m:machines) {
            m.setId(null);
            mineMachineService.save(m);
        }

        str="[{\"createDate\":\"2020-07-23 00:34:36\",\"creator\":1,\"modifyDate\":\"2020-11-21 13:54:09\",\"modifier\":1,\"version\":0,\"id\":212,\"type\":1,\"name\":\"????????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-07-23/338478556696805376228799_2020-07-23.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":49.8,\"invest\":1,\"profit\":0.00000714,\"rmbElectricPrice\":0,\"electric\":0.0685,\"electricDiscount\":1,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":330.174,\"stock\":809412,\"isStock\":false,\"expirationDate\":\"2021-08-01 00:00:00\",\"validity\":\"[3,0,0]\",\"isRecommend\":false,\"newsId\":221,\"investTime\":null,\"btcDiscount\":1,\"hbtDiscount\":0,\"hbtDiscountType\":1,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":1,\"exchangeRate\":6.63,\"productId\":null}]";
        machines = JsonUtils.toObject(str, new TypeReference<List<MineMachine>>() {
        });
        for (MineMachine m:machines) {
            m.setId(null);
            mineMachineService.save(m);
        }

        str="[{\"createDate\":\"2020-11-11 22:35:05\",\"creator\":1,\"modifyDate\":\"2020-11-21 00:03:08\",\"modifier\":1,\"version\":0,\"id\":249,\"type\":5,\"name\":\"ETH????????????????????????5???\",\"tag\":\"?????????,?????????\",\"icon\":\"/static/images/product/2020-11-11/379035619336126464682361_2020-11-11.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":682.22,\"price\":108.9,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0.53,\"electric\":0.008,\"electricDiscount\":0.8,\"manage\":6,\"manageDiscount\":0.5,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":722.007,\"stock\":998737,\"isStock\":false,\"expirationDate\":\"2020-12-01 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":220,\"investTime\":\"2020-12-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":400,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-31 16:33:15\",\"creator\":1,\"modifyDate\":\"2020-11-11 09:00:57\",\"modifier\":1,\"version\":0,\"id\":239,\"type\":5,\"name\":\"ETH??????????????????11??????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-31/374958361248006144824935_2020-10-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":602.1,\"price\":97,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0.53,\"electric\":0.008,\"electricDiscount\":0.8,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":3,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":643.11,\"stock\":998697,\"isStock\":false,\"expirationDate\":\"2020-11-12 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":255,\"investTime\":\"2020-12-12 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":400,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-25 18:08:23\",\"creator\":1,\"modifyDate\":\"2020-10-26 00:01:24\",\"modifier\":1,\"version\":0,\"id\":236,\"type\":5,\"name\":\"ETH?????????????????????????????????1???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-25/372808229756862464698005_2020-10-25.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":90,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0,\"electric\":0.008,\"electricDiscount\":0,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":10,\"defaultBuyNumber\":10,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":596.7,\"stock\":999914,\"isStock\":false,\"expirationDate\":\"2020-11-01 00:00:00\",\"validity\":\"[1,0,0]\",\"isRecommend\":false,\"newsId\":251,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":200,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-25 18:04:18\",\"creator\":1,\"modifyDate\":\"2020-11-01 07:49:35\",\"modifier\":1,\"version\":0,\"id\":235,\"type\":5,\"name\":\"ETH?????????????????????????????????-?????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-25/372806900527398912875147_2020-10-25.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":136,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0,\"electric\":0.008,\"electricDiscount\":0,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":3,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":901.68,\"stock\":999434,\"isStock\":false,\"expirationDate\":\"2020-11-01 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":220,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":500,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-18 17:31:31\",\"creator\":1,\"modifyDate\":\"2020-11-01 08:38:48\",\"modifier\":1,\"version\":0,\"id\":234,\"type\":5,\"name\":\"ETH?????????????????????????????????????????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-18/370261736126676992719469_2020-10-18.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":136,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0,\"electric\":0.008,\"electricDiscount\":0,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":901.68,\"stock\":992018,\"isStock\":false,\"expirationDate\":\"2020-10-26 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":220,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":700,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null}]";
        machines = JsonUtils.toObject(str, new TypeReference<List<MineMachine>>() {
        });
        for (MineMachine m:machines) {
            m.setId(null);
            mineMachineService.save(m);
        }

        str="[{\"createDate\":\"2020-11-11 22:35:05\",\"creator\":1,\"modifyDate\":\"2020-11-21 00:03:08\",\"modifier\":1,\"version\":0,\"id\":249,\"type\":5,\"name\":\"ETH????????????????????????5???\",\"tag\":\"?????????,?????????\",\"icon\":\"/static/images/product/2020-11-11/379035619336126464682361_2020-11-11.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":682.22,\"price\":108.9,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0.53,\"electric\":0.008,\"electricDiscount\":0.8,\"manage\":6,\"manageDiscount\":0.5,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":722.007,\"stock\":998737,\"isStock\":false,\"expirationDate\":\"2020-12-01 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":220,\"investTime\":\"2020-12-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":400,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-31 16:33:15\",\"creator\":1,\"modifyDate\":\"2020-11-11 09:00:57\",\"modifier\":1,\"version\":0,\"id\":239,\"type\":5,\"name\":\"ETH??????????????????11??????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-31/374958361248006144824935_2020-10-31.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":602.1,\"price\":97,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0.53,\"electric\":0.008,\"electricDiscount\":0.8,\"manage\":6,\"manageDiscount\":0,\"profitYear\":56,\"limit\":3,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":643.11,\"stock\":998697,\"isStock\":false,\"expirationDate\":\"2020-11-12 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":255,\"investTime\":\"2020-12-12 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":400,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-25 18:08:23\",\"creator\":1,\"modifyDate\":\"2020-10-26 00:01:24\",\"modifier\":1,\"version\":0,\"id\":236,\"type\":5,\"name\":\"ETH?????????????????????????????????1???\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-25/372808229756862464698005_2020-10-25.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":90,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0,\"electric\":0.008,\"electricDiscount\":0,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":10,\"defaultBuyNumber\":10,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":596.7,\"stock\":999914,\"isStock\":false,\"expirationDate\":\"2020-11-01 00:00:00\",\"validity\":\"[1,0,0]\",\"isRecommend\":false,\"newsId\":251,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":200,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-25 18:04:18\",\"creator\":1,\"modifyDate\":\"2020-11-01 07:49:35\",\"modifier\":1,\"version\":0,\"id\":235,\"type\":5,\"name\":\"ETH?????????????????????????????????-?????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-25/372806900527398912875147_2020-10-25.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":136,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0,\"electric\":0.008,\"electricDiscount\":0,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":3,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":901.68,\"stock\":999434,\"isStock\":false,\"expirationDate\":\"2020-11-01 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":220,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":500,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null},{\"createDate\":\"2020-10-18 17:31:31\",\"creator\":1,\"modifyDate\":\"2020-11-01 08:38:48\",\"modifier\":1,\"version\":0,\"id\":234,\"type\":5,\"name\":\"ETH?????????????????????????????????????????????\",\"tag\":\"\",\"icon\":\"/static/images/product/2020-10-18/370261736126676992719469_2020-10-18.jpg\",\"images\":null,\"saleType\":1,\"rmbPrice\":0,\"price\":136,\"invest\":10,\"profit\":0.00006514,\"rmbElectricPrice\":0,\"electric\":0.008,\"electricDiscount\":0,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":3,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":901.68,\"stock\":992018,\"isStock\":false,\"expirationDate\":\"2020-10-26 00:00:00\",\"validity\":\"[2,0,0]\",\"isRecommend\":false,\"newsId\":220,\"investTime\":\"2020-11-01 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":700,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null}]";
        machines = JsonUtils.toObject(str, new TypeReference<List<MineMachine>>() {
        });
        for (MineMachine m:machines) {
            m.setId(null);
            mineMachineService.save(m);
        }

        str="[{\"createDate\":\"2020-11-11 22:15:49\",\"creator\":1,\"modifyDate\":\"2020-11-12 09:56:45\",\"modifier\":1,\"version\":0,\"id\":246,\"type\":5,\"name\":\"ETH????????????-RX580-8G-8?????????2??????\",\"tag\":\"????????????\",\"icon\":\"/static/images/product/2020-11-11/379030773467971584447073_2020-11-11.jpg\",\"images\":null,\"saleType\":2,\"rmbPrice\":15000,\"price\":2262.4434,\"invest\":210,\"profit\":0.00006514,\"rmbElectricPrice\":12,\"electric\":0.00861,\"electricDiscount\":1,\"manage\":6,\"manageDiscount\":1,\"profitYear\":56,\"limit\":1,\"defaultBuyNumber\":1,\"isMarketable\":true,\"isSpecials\":false,\"specialsIcon\":null,\"monthSales\":0,\"profitDay\":false,\"returnProfitDay\":null,\"weekSales\":0,\"sales\":0,\"money\":14999.999742,\"stock\":0,\"isStock\":false,\"expirationDate\":\"2020-12-01 00:00:00\",\"validity\":\"[51,0,0]\",\"isRecommend\":false,\"newsId\":258,\"investTime\":\"2020-12-02 00:00:00\",\"btcDiscount\":0,\"hbtDiscount\":5000,\"hbtDiscountType\":2,\"maxLimit\":null,\"earnest\":null,\"returnRate\":null,\"interest\":null,\"surplus\":null,\"maxQouta\":null,\"isReward\":null,\"hierarchy\":null,\"coinType\":5,\"exchangeRate\":6.63,\"productId\":null}]";
        machines = JsonUtils.toObject(str, new TypeReference<List<MineMachine>>() {
        });
        for (MineMachine m:machines) {
            m.setId(null);
            mineMachineService.save(m);
        }




        return Result.success(machines);
    }

    @GetMapping("/init/adversite")
    public Result adversite (){
        String str = "[{\"id\":60,\"code\":\"1001\",\"picurl\":\"https://hashbox-news.oss-cn-hangzhou.aliyuncs.com/upload/news/20201204/97UOGEXFHS8KaDMJUgmT7BncYe3gDFIq.jpg\",\"linkurl\":\"\",\"orders\":\"11\",\"state\":true,\"title\":\"\",\"type\":1},{\"id\":57,\"code\":\"1001\",\"picurl\":\"https://hashbox-news.oss-cn-hangzhou.aliyuncs.com/upload/news/20201017/RJpKEIjcJ1q94m9FiQkePG94YAP54GGB.jpg\",\"linkurl\":\"\",\"orders\":\"10\",\"state\":true,\"title\":\"\",\"type\":1},{\"id\":50,\"code\":\"1001\",\"picurl\":\"https://hashbox-news.oss-cn-hangzhou.aliyuncs.com/upload/news/20200722/0pU4kAE8n3PGFdGYLe1KchhWNAYK0LU2.jpg\",\"linkurl\":\"\",\"orders\":\"7\",\"state\":true,\"title\":\"\",\"type\":1},{\"id\":22,\"code\":\"1001\",\"picurl\":\"https://hashbox-news.oss-cn-hangzhou.aliyuncs.com/upload/news/20201027/JY6UfAcflErHU1bIBJ5SUAaVBMA6QT7h.jpg\",\"linkurl\":\"\",\"orders\":\"4\",\"state\":true,\"title\":\"\",\"type\":1},{\"id\":25,\"code\":\"1001\",\"picurl\":\"https://hashbox-news.oss-cn-hangzhou.aliyuncs.com/upload/news/20201026/PTMi35rDF53DZGe49kbX5nHbMrANQqFX.jpg\",\"linkurl\":\"\",\"orders\":\"3\",\"state\":true,\"title\":\"\",\"type\":1},{\"id\":26,\"code\":\"1001\",\"picurl\":\"https://hashbox-news.oss-cn-hangzhou.aliyuncs.com/upload/news/20201027/jSqokipM82PGGhr2XK2PTkK0EcojD3jk.jpg\",\"linkurl\":\"\",\"orders\":\"1\",\"state\":true,\"title\":\"\",\"type\":1}]";
        List<Adversite> machines = JsonUtils.toObject(str, new TypeReference<List<Adversite>>() {
        });
        for (Adversite m:machines) {
            m.setId(null);
            adversiteService.save(m);
        }
        return Result.success(machines);
    }

    @GetMapping("/init/mineMachine")
    public Result mineMachine (String name){
        if(StringUtils.isNotBlank(name)){
            MineMachine mineMachine = mineMachineService.findDefault();
            MineMachine newMineMachine = new MineMachine();
            BeanUtils.copyProperties(mineMachine,newMineMachine,"id");
            newMineMachine.setName(name);
            mineMachineService.save(newMineMachine);
        }
        return Result.success("");
    }

}
