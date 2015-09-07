/* Copyright (c) 2015 SWM Services GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 * Sebastian Schmidt (SWM Services GmbH) - initial implementation
 */
package org.locationtech.geogig.storage.integration.mapdb;

import org.locationtech.geogig.api.Context;
import org.locationtech.geogig.di.GeogigModule;

import com.google.inject.Guice;
import com.google.inject.util.Modules;

public class MapdbDiffOpTest extends org.locationtech.geogig.test.integration.DiffOpTest {
    @Override
    protected Context createInjector() {
        return Guice.createInjector(
                Modules.override(new GeogigModule()).with(new MapdbTestStorageModule()))
                .getInstance(Context.class);
    }
}
