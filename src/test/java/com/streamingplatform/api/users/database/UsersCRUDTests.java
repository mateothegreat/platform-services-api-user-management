/*
 * Copyright (C) 2017 Matthew Davis <matthew@appsoa.io>
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.streamingplatform.api.users.database;

import com.streamingplatform.api.users.UsersApplication;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UsersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureTestDatabase
public class UsersCRUDTests {






    private static final String USERS_ENDPOINT = "/users";
    @Autowired
    private TestRestTemplate template;




    @Test
    public void findAll() throws JSONException {

        //        HttpHeaders httpHeaders = new HttpHeaders();
        //
        //        HttpEntity<String> httpEntity = new HttpEntity<>(USERS_ENDPOINT, httpHeaders);
        //
        //        template.exchange(USERS_ENDPOINT, HttpMethod.GET, httpEntity, String.class);

        String jsonResponse = template.getForObject(USERS_ENDPOINT, String.class);

        //        assertEquals("invalid http response", jsonResponse.)
        JSONObject jsonObject = new JSONObject(jsonResponse).getJSONObject("_embedded");
        JSONArray  jsonArray  = jsonObject.getJSONArray("users");

        System.out.print(jsonResponse);
        System.out.print(jsonArray.get(0));

    }

}
