/* Copyright (c) 2015-2016 Boundless and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 * Gabriel Roldan (Boundless) - initial implementation
 */
package org.locationtech.geogig.model.impl;

import org.locationtech.geogig.model.Node;
import org.locationtech.geogig.model.NodeOrdering;
import org.locationtech.geogig.model.RevTree;
import org.locationtech.geogig.model.internal.ClusteringStrategy;
import org.locationtech.geogig.model.internal.ClusteringStrategyBuilder;
import org.locationtech.geogig.storage.ObjectStore;
import org.locationtech.jts.geom.Envelope;

import com.google.common.base.Preconditions;

public class QuadTreeBuilder extends AbstractTreeBuilder implements RevTreeBuilder {

    private final ClusteringStrategy clusteringStrategy;

    protected QuadTreeBuilder(ObjectStore store, RevTree original, ClusteringStrategy strategy) {
        super(store, original);
        clusteringStrategy = strategy;
    }

    @Override
    public boolean put(Node node) {
        return super.put(node);
    }

    @Override
    public boolean remove(Node node) {
        return super.remove(node);
    }

    @Override
    public boolean update(Node oldNode, Node newNode) {
        return super.update(oldNode, newNode);
    }

    @Override
    protected final ClusteringStrategy clusteringStrategy() {
        return clusteringStrategy;
    }

    public static QuadTreeBuilder create(final ObjectStore source, final ObjectStore target,
            final RevTree original, final Envelope maxBounds) {
        Preconditions.checkNotNull(source);
        Preconditions.checkNotNull(target);
        Preconditions.checkNotNull(original);
        Preconditions.checkNotNull(maxBounds);

        ClusteringStrategy strategy = ClusteringStrategyBuilder//
                .quadTree(source)//
                .original(original)//
                .maxBounds(maxBounds)//
                .build();
        QuadTreeBuilder builder = new QuadTreeBuilder(target, RevTree.EMPTY, strategy);
        return builder;
    }

    public static NodeOrdering nodeOrdering(Envelope maxBounds) {
        return ClusteringStrategyBuilder.quadTreeOrdering(maxBounds);
    }
}
