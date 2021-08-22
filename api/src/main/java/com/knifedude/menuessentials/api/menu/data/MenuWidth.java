/*
 * Copyright (C) 2018 ching.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.knifedude.menuessentials.api.menu.data;

/**
 * Represents all the supported widths
 * @author knifedude
 */
public enum MenuWidth {
    
    THREE(3),
    SIX(6),
    NINE(9);
    
    private final int value;
    
    MenuWidth(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    
}
