/*
 * Copyright © 2018 Mercateo AG (http://www.mercateo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jsonhoist;

import org.jsonhoist.trans.JsonTransformation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Encapsulates one transformation step. Note that
 * {@link com.mercateo.jsonhoist.trans.JSJsonTransformation} is a subclass,
 * which can be used for optimizations
 *
 * @author usr
 *
 */
public abstract class AbstractJsonTransformation implements JsonTransformation {

	// does not have to be configured, just used for simple transformations
	static protected final ObjectMapper om = JsonHoistInternalObjectMapper.getInstance();

	/*
	 * (non-Javadoc)
	 *
	 * @see com.mercateo.jsonupcaster.trans.JsonTransformation#transform(com.
	 * fasterxml.jackson.databind.JsonNode)
	 */
	@Override
	public abstract JsonNode transform(JsonNode source);

}
