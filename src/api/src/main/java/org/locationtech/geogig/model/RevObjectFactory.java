/* Copyright (c) 2018 Boundless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 * Gabriel Roldan - initial implementation
 */
package org.locationtech.geogig.model;

import java.util.List;
import java.util.SortedMap;

import org.opengis.feature.type.FeatureType;

import lombok.NonNull;

/**
 * A factory for {@link RevObject} instances with methods for each concrete model object type.
 * <p>
 * The default implementation is to be acquired using {@link #defaultInstance()}, and is figured out
 * in this order:
 * <ul>
 * <li>1. By the {@code RevObjectFactory} <strong>System property</strong> (e.g. {@code java
 * -DRevObjectFactory=org.locationtech.geogig.model.impl.RevObjectFactoryImpl}
 * <li>2. By the {@code RevObjectFactory} <strong>environment variable</strong> (e.g. {@code export
 * RevObjectFactory=org.locationtech.geogig.model.impl.RevObjectFactoryImpl && java ...}
 * <li>3. By using the <strong>{@code java.util.ServiceLoader} SPI</strong> mechanism looking for
 * implementations of {@code org.locationtech.geogig.model.RevObjectFactory}, and choosing the one
 * with the highest {@link RevObjectFactory#getPriority() RevObjectFactory.getPriority():int} in
 * case there are multiple implementations in the classpath.
 *
 */
public interface RevObjectFactory extends PriorityService {

    /**
     * Returns the default implementation of {@code RevObjectFactory} found as descried in this
     * class' javadocs.
     */
    public static RevObjectFactory defaultInstance() {
        return RevObjects.lookupDefaultFactory();
    }

    public @NonNull RevCommit createCommit(@NonNull ObjectId id, @NonNull ObjectId treeId,
            @NonNull List<ObjectId> parents, @NonNull RevPerson author,
            @NonNull RevPerson committer, @NonNull String message);

    public @NonNull RevTree createTree(@NonNull ObjectId id, long size, @NonNull List<Node> trees,
            @NonNull List<Node> features);

    public @NonNull RevTree createTree(@NonNull ObjectId id, long size, int childTreeCount,
            @NonNull SortedMap<Integer, Bucket> buckets);

    public @NonNull RevTag createTag(@NonNull ObjectId id, @NonNull String name,
            @NonNull ObjectId commitId, @NonNull String message, @NonNull RevPerson tagger);

    public @NonNull RevFeatureType createFeatureType(@NonNull ObjectId id,
            @NonNull FeatureType ftype);

    public @NonNull RevFeature createFeature(@NonNull ObjectId id, @NonNull List<Object> values);

    public @NonNull RevFeature createFeature(@NonNull ObjectId id, @NonNull Object... values);
}