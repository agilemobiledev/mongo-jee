/**
 * Copyright (C) 2012 Angelo Zerr <angelo.zerr@gmail.com> and Pascal Leclercq <pascal.leclercq@gmail.com>
 * 
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mongodb.jee;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 
 * Simple Pojo of page result.
 * 
 */
public class PageResult {

	private final Iterable<DBObject> items;
	private final int fromItemIndex;
	private final int toItemIndex;
	private final int totalItems;

	public PageResult(DBCursor cursor, int fromItemIndex, int toItemIndex) {
		this(cursor.skip(fromItemIndex).limit(toItemIndex - fromItemIndex + 1),
				fromItemIndex, toItemIndex, cursor.count());
	}

	public PageResult(Iterable<DBObject> items, int fromItemIndex,
			int toItemIndex, int totalItems) {
		this.items = items;
		this.fromItemIndex = fromItemIndex;
		this.toItemIndex = toItemIndex;
		this.totalItems = totalItems;
	}

	/**
	 * Returns the paginated items.
	 * 
	 * @return
	 */
	public Iterable<DBObject> getItems() {
		return items;
	}

	/**
	 * Return the total items.
	 * 
	 * @return
	 */
	public int getTotalItems() {
		return totalItems;
	}

	/**
	 * Returns the from item index of the page.
	 * 
	 * @return
	 */
	public int getFromItemIndex() {
		return fromItemIndex;
	}

	/**
	 * Returns the to item index of the page.
	 * 
	 * @return
	 */
	public int getToItemIndex() {
		return toItemIndex;
	}
}
