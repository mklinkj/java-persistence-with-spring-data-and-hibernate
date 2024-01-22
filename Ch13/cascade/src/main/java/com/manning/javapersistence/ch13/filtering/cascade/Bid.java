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
package com.manning.javapersistence.ch13.filtering.cascade;

import com.manning.javapersistence.ch13.Constants;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Bid {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private BigDecimal amount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    public Bid() {
    }

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Bid bid) {
            return Objects.equals(id, bid.id) &&
                    Objects.equals(amount, bid.amount) &&
                    Objects.equals(item, bid.item);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, item);
    }
}
