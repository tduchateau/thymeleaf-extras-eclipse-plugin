/*
 * Copyright 2013, The Thymeleaf Project (http://www.thymeleaf.org/)
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

package org.thymeleaf.extras.eclipse.dialect;

import org.thymeleaf.extras.eclipse.dialect.DialectLocator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Locates the Thymeleaf dialect XML files that come bundled with this plugin.
 * 
 * @author Emanuel Rabina
 */
public class BundledDialectLocator implements DialectLocator<InputStream> {

	private static final String[] DIALECT_FILES = {
			"dialects/Standard-Dialect.xml",
			"dialects/Spring-Standard-Dialect.xml",
			"dialects/Spring-Security-Dialect.xml",
			"dialects/Tiles-Dialect.xml"
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<InputStream> locateDialects() {

		ArrayList<InputStream> dialectstreams = new ArrayList<InputStream>();
		for (String dialectfile: DIALECT_FILES) {
			dialectstreams.add(BundledDialectLocator.class.getClassLoader()
					.getResourceAsStream(dialectfile));
		}
		return dialectstreams;
	}
}
