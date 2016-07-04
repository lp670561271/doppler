/*
 * Copyright jd
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.sinoservices.doppler.dao.impl;


import com.sinoservices.doppler.dao.AppMapper;
import com.sinoservices.doppler.entity.AnnoWebServiceDB;
import com.sinoservices.doppler.entity.AppDB;
import com.sinoservices.doppler.entity.ServiceDB;
import com.sinoservices.util.ST;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: xiangkui
 * Date: 13-4-1
 * Time: 下午1:15
 */
@Repository("appMapper")
public class AppMapperImpl implements AppMapper {
    @Autowired
    private SqlSessionTemplate sqlSession;



    public AppDB getAppById(Integer id) {
        ST.start();
        Map map = new HashMap();
        map.put("id",id);
        AppDB appDB = (AppDB) sqlSession.selectOne("getByAppId",map);
        ST.stop();
        return appDB;
    }

    public List<AppDB> getAppAll() {
        ST.start();
        List<AppDB> list = (List<AppDB>)sqlSession.selectList("getAppAll");
        ST.stop();
        return list;
    }

    public List<AppDB> getAppServiceByService() {
        ST.start();
        List<AppDB> list = (List<AppDB>)sqlSession.selectList("getAppAll");
        ST.stop();
        return list;
    }
}
