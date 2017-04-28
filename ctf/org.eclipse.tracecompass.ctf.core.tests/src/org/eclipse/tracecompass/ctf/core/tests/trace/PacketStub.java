/*******************************************************************************
 * Copyright (c) 2017 Ericsson
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.tracecompass.ctf.core.tests.trace;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.tracecompass.ctf.core.trace.ICTFPacketDescriptor;

/**
 * Internal implementation to test packet index
 *
 * @author Matthew Khouzam
 */
class PacketStub implements ICTFPacketDescriptor {

    private final long fOffsetBytes;
    private final long fTsStart;
    private final long fTsEnd;

    public PacketStub(long offset, long start, long end) {
        fOffsetBytes = offset;
        fTsStart = start;
        fTsEnd = end;
    }

    @Override
    public boolean includes(long ts) {
        return ts >= fTsStart && ts <= fTsEnd;
    }

    @Override
    public long getOffsetBits() {
        return fOffsetBytes * 8;
    }

    @Override
    public long getPacketSizeBits() {
        return 0;
    }

    @Override
    public long getContentSizeBits() {
        return 0;
    }

    @Override
    public long getTimestampBegin() {
        return fTsStart;
    }

    @Override
    public long getTimestampEnd() {
        return fTsEnd;
    }

    @Override
    public long getLostEvents() {
        return 0;
    }

    @Override
    public @NonNull Map<String, Object> getAttributes() {
        return Collections.emptyMap();
    }

    @Override
    public String getTarget() {
        return "";
    }

    @Override
    public long getTargetId() {
        return 0;
    }

    @Override
    public long getOffsetBytes() {
        return fOffsetBytes;
    }

    @Override
    public long getPayloadStartBits() {
        return 0;
    }

    @Override
    public String toString() {
        return "[" + fOffsetBytes + ", " + fTsStart + " - " + fTsEnd + "]";
    }

}