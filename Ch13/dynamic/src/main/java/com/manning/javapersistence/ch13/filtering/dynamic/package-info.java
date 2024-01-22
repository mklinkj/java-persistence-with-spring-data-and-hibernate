/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
@org.hibernate.annotations.FilterDefs({
    @org.hibernate.annotations.FilterDef(
        name = "limitByUserRanking",
        parameters = {
            @org.hibernate.annotations.ParamDef(
                name = "currentUserRanking", type = IntegerJavaType.class
            )
        }
    )
    ,
    @org.hibernate.annotations.FilterDef(
        name = "limitByUserRankingDefault",
        defaultCondition= """
            :currentUserRanking >= (
                    select u.RANKING from USERS u
                    where u.ID = SELLER_ID
                )""",
        parameters = {
            @org.hibernate.annotations.ParamDef(
                name = "currentUserRanking", type = IntegerJavaType.class
            )
        }
    )
})
package com.manning.javapersistence.ch13.filtering.dynamic;

import org.hibernate.type.descriptor.java.IntegerJavaType;