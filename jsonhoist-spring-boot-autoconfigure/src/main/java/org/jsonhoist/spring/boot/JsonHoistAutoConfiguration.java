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
package org.jsonhoist.spring.boot;

import java.io.IOException;

import org.jsonhoist.HoistMetaDataProcessor;
import org.jsonhoist.HoistMetadataProcessorImpl;
import org.jsonhoist.HoistObjectMapper;
import org.jsonhoist.JsonHoist;
import org.jsonhoist.JsonHoistImpl;
import org.jsonhoist.trans.ClassPathJSJsonTransformationLoader;
import org.jsonhoist.trans.JsonTransformationRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Spring configuration class for defining defaults for autoconfiguration. Might
 * be extracted out, so that jsonUpcaster is not tied to spring usage.
 *
 * @author usr
 *
 */

@Configuration
public class JsonHoistAutoConfiguration {

	@ConditionalOnMissingBean
	@Bean
	public HoistMetaDataProcessor hoistMetaDataProcessor() {
		return new HoistMetadataProcessorImpl();
	}

	@ConditionalOnMissingBean
	@Bean
	public JsonTransformationRepository transformationRepository() {
		return new JsonTransformationRepository();
	}

	@ConditionalOnProperty(prefix = "jsonhoist.repository.classpath", name = "enabled")
	@Bean
	public ClassPathJSJsonTransformationLoader loader(JsonTransformationRepository repo) throws IOException {
		ClassPathJSJsonTransformationLoader classPathJSJsonTransformationLoader = new ClassPathJSJsonTransformationLoader(
				repo);
		classPathJSJsonTransformationLoader.load();
		return classPathJSJsonTransformationLoader;
	}

	@ConditionalOnMissingBean
	@Bean
	public HoistObjectMapper hoistObjectMapper(ObjectMapper objectMapper, JsonHoist hoist) {
		return new HoistObjectMapper(objectMapper, hoist);
	}

	@ConditionalOnMissingBean
	@Bean
	public JsonHoist jsonHoist(HoistMetaDataProcessor proc, JsonTransformationRepository repo) {
		return new JsonHoistImpl(proc, repo);
	}

	@ConditionalOnMissingBean
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
