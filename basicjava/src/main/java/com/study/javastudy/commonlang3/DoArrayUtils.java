package com.study.javastudy.commonlang3;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.ArrayUtils;


import java.io.Serializable;

public class DoArrayUtils {
    public static void main(String[] args) {
        boolean[] bArray = ArrayUtils.add(ArrayUtils.EMPTY_BOOLEAN_ARRAY, true);
        System.out.println(ArrayUtils.toString(bArray));

        String[] strings = ArrayUtils.toArray("abc", "aaa", "123");
        String[] strings2 = {"abc,","hahaha"};

//        String jsonStr = "{\"total\":19,\"data\":[{\"plateNo\":\"辽BJ8552\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"洪奇军\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-04-29T15:38:59+08:00\",\"createTime\":\"2019-04-29T18:13:49+08:00\",\"updateTime\":\"2019-04-29T18:13:49+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BL9791\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"大连龙润物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"NOT_ENABLE\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-22T09:37:58+08:00\",\"createTime\":\"2019-04-29T18:19:05+08:00\",\"updateTime\":\"2019-04-29T18:20:04+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BM3732\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"大连龙润物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"NOT_ENABLE\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-22T09:22:06+08:00\",\"createTime\":\"2019-04-29T18:38:26+08:00\",\"updateTime\":\"2019-04-29T18:38:26+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽B6B836\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"UNREGISTER\",\"owner\":\"吴国谦\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-22T09:41:25+08:00\",\"createTime\":\"2019-04-29T18:40:18+08:00\",\"updateTime\":\"2019-04-29T18:40:18+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽B6B906\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"王国杰\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"DISABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-22T09:15:14+08:00\",\"createTime\":\"2019-04-29T21:29:00+08:00\",\"updateTime\":\"2019-06-30T04:52:21+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽HE0851\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"营口均鼎物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"DISABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2020-03-12T07:09:54+08:00\",\"createTime\":\"2019-04-29T21:42:33+08:00\",\"updateTime\":\"2020-03-12T05:11:44+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽P20781\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"UNREGISTER\",\"owner\":\"葫芦岛海港物贸有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2019-10-22T10:13:17+08:00\",\"createTime\":\"2019-04-29T21:43:37+08:00\",\"updateTime\":\"2019-10-22T04:54:51+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BM5839\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"大连龙润物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"NOT_ENABLE\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-23T08:53:16+08:00\",\"createTime\":\"2019-04-29T21:45:35+08:00\",\"updateTime\":\"2019-05-08T04:56:11+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BE1897\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"张明秀\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-22T08:26:28+08:00\",\"createTime\":\"2019-04-29T21:46:19+08:00\",\"updateTime\":\"2019-04-29T21:46:19+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"鲁HQF586\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"梁山县祥骏汽车贸易有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2019-10-21T17:49:52+08:00\",\"createTime\":\"2019-04-29T21:46:25+08:00\",\"updateTime\":\"2019-10-22T04:56:07+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽H1558A\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"营口亚泰运输有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"DISABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2020-03-12T07:13:02+08:00\",\"createTime\":\"2019-04-29T21:48:04+08:00\",\"updateTime\":\"2020-03-12T05:11:43+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"吉C26718\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"四平市金丰运输有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2019-10-21T18:13:47+08:00\",\"createTime\":\"2019-04-29T21:48:29+08:00\",\"updateTime\":\"2019-10-22T04:56:43+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BN5656\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"大连龙润物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"NOT_ENABLE\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-23T07:35:36+08:00\",\"createTime\":\"2019-04-29T21:49:36+08:00\",\"updateTime\":\"2019-04-29T21:49:36+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BN2152\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"大连龙润物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"NOT_ENABLE\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-23T09:02:43+08:00\",\"createTime\":\"2019-04-29T21:51:37+08:00\",\"updateTime\":\"2019-04-29T21:51:37+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BD1705\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"UNREGISTER\",\"owner\":\"吴国谦\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-23T09:10:58+08:00\",\"createTime\":\"2019-04-29T21:52:51+08:00\",\"updateTime\":\"2019-04-29T21:52:51+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BXH601\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"俞祥福\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"ENABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-22T07:12:39+08:00\",\"createTime\":\"2019-04-29T21:53:14+08:00\",\"updateTime\":\"2019-04-29T21:53:14+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"皖KB7215\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"UNREGISTER\",\"owner\":\"阜阳市石丰汽车运输有限责任公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"DISABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2020-03-12T07:01:22+08:00\",\"createTime\":\"2019-04-29T21:55:24+08:00\",\"updateTime\":\"2020-03-12T05:11:45+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽BM5899\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"SERVICE\",\"owner\":\"大连龙润物流有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"NOT_ENABLE\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"\",\"loginkQueryTime\":\"2019-10-21T18:38:29+08:00\",\"createTime\":\"2019-04-29T21:56:28+08:00\",\"updateTime\":\"2019-04-29T21:56:28+08:00\",\"isSelfOwned\":null},{\"plateNo\":\"辽H62621\",\"plateColor\":\"YELLOW\",\"businessStateCode\":\"UNREGISTER\",\"owner\":\"营口经济技术开发区裕程公路集装箱运输有限公司\",\"ownerCertType\":\"\",\"ownerCertNo\":\"\",\"imeiStatus\":\"DISABLED\",\"etcStatus\":\"ENABLED\",\"oilStatus\":\"NOT_ENABLE\",\"tanchengStatus\":\"\",\"importStatus\":\"NOT_ENABLE\",\"chemanmanStatus\":\"NOT_ENABLE\",\"loginkQueryTime\":\"2020-03-12T07:12:37+08:00\",\"createTime\":\"2019-04-29T21:57:43+08:00\",\"updateTime\":\"2020-03-12T05:11:44+08:00\",\"isSelfOwned\":null}]}";
    String jsonStr = "{\n" +
            "\t\"total\": 13,\n" +
            "\t\"data\": [{\n" +
            "\t\t\"plateNo\": \"辽BJ8552\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"SERVICE\",\n" +
            "\t\t\"owner\": \"洪奇军\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-04-29T15:38:59+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T18:13:49+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-04-29T18:13:49+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽B6B836\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"UNREGISTER\",\n" +
            "\t\t\"owner\": \"吴国谦\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-22T09:41:25+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T18:40:18+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-04-29T18:40:18+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽H20692\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"UNREGISTER\",\n" +
            "\t\t\"owner\": \"营口汇海物流运输有限公司\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-23T07:46:19+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T20:59:48+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-10-22T04:55:43+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽P20781\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"UNREGISTER\",\n" +
            "\t\t\"owner\": \"葫芦岛海港物贸有限公司\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-22T10:13:17+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:43:37+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-10-22T04:54:51+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽BE1897\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"SERVICE\",\n" +
            "\t\t\"owner\": \"张明秀\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-22T08:26:28+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:46:19+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-04-29T21:46:19+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"鲁HQF586\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"SERVICE\",\n" +
            "\t\t\"owner\": \"梁山县祥骏汽车贸易有限公司\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-21T17:49:52+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:46:25+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-10-22T04:56:07+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"吉C26718\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"SERVICE\",\n" +
            "\t\t\"owner\": \"四平市金丰运输有限公司\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-21T18:13:47+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:48:29+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-10-22T04:56:43+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽BDR112\",\n" +
            "\t\t\"plateColor\": \"\",\n" +
            "\t\t\"businessStateCode\": \"\",\n" +
            "\t\t\"owner\": \"\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"loginkQueryTime\": \"\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:50:03+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-10-22T04:56:48+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽BD1705\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"UNREGISTER\",\n" +
            "\t\t\"owner\": \"吴国谦\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-23T09:10:58+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:52:51+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-04-29T21:52:51+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}, {\n" +
            "\t\t\"plateNo\": \"辽BXH601\",\n" +
            "\t\t\"plateColor\": \"YELLOW\",\n" +
            "\t\t\"businessStateCode\": \"SERVICE\",\n" +
            "\t\t\"owner\": \"俞祥福\",\n" +
            "\t\t\"ownerCertType\": \"\",\n" +
            "\t\t\"ownerCertNo\": \"\",\n" +
            "\t\t\"imeiStatus\": \"ENABLED\",\n" +
            "\t\t\"etcStatus\": \"ENABLED\",\n" +
            "\t\t\"oilStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"tanchengStatus\": \"\",\n" +
            "\t\t\"importStatus\": \"NOT_ENABLE\",\n" +
            "\t\t\"chemanmanStatus\": \"\",\n" +
            "\t\t\"loginkQueryTime\": \"2019-10-22T07:12:39+08:00\",\n" +
            "\t\t\"createTime\": \"2019-04-29T21:53:14+08:00\",\n" +
            "\t\t\"updateTime\": \"2019-04-29T21:53:14+08:00\",\n" +
            "\t\t\"isSelfOwned\": null\n" +
            "\t}]\n" +
            "}";
        String json;
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        JSONArray data = JSONArray.parseArray(jsonObject.getString("data"));
      for( int i = 0; i< data.size(); i++){
          String plateNo = data.getJSONObject(i).getString("plateNo");
          System.out.println(plateNo);
      }



    }
}
