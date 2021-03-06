/*
 *
 *  Copyright 2016 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.metacat.common.server.util;

import com.netflix.metacat.common.MetacatRequestContext;

/**
 * Metacat context manager.
 */
public final class MetacatContextManager {
    private static InheritableThreadLocal<MetacatRequestContext> context = new InheritableThreadLocal<>();

    private MetacatContextManager() {
    }

    /**
     * Removes the context from this manager.
     */
    public static void removeContext() {
        context.remove();
    }

    /**
     * Returns the current thread context.
     *
     * @return context
     */
    public static MetacatRequestContext getContext() {
        MetacatRequestContext result = context.get();
        if (result == null) {
            result = new MetacatRequestContext();
            setContext(result);
        }
        return result;
    }

    /**
     * Sets the context in this manager.
     *
     * @param context context
     */
    public static void setContext(final MetacatRequestContext context) {
        MetacatContextManager.context.set(context);
    }
}
