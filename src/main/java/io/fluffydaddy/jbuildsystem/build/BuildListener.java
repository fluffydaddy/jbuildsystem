/*
 * Copyright © 2024 fluffydaddy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fluffydaddy.jbuildsystem.build;

import io.fluffydaddy.jbuildsystem.event.ProgressEvent;

/**
 * Listener for the build system.
 * Here, you can learn about all possible build events.
 *
 * @param <R> The result after the build execution.
 */
public interface BuildListener<R> {
    /**
     * The build system starts building the project.
     *
     * @param buildSystem The current build system.
     */
    void buildStarted(BuildSystem<R> buildSystem);

    /**
     * The build system notifies about progress.
     *
     * @param buildSystem   The current build system.
     * @param progressEvent The event passed by the build system.
     */
    void buildProgress(BuildSystem<R> buildSystem, ProgressEvent progressEvent);

    /**
     * The build system encountered an error.
     *
     * @param buildSystem The current build system.
     * @param cause       The exception that interrupted the project build.
     */
    void buildFailure(BuildSystem<R> buildSystem, Throwable cause);

    /**
     * Called when the build is successfully completed with a result.
     *
     * @param buildSystem The current build system.
     * @param result      The result after the build execution.
     */
    void buildComplete(BuildSystem<R> buildSystem, R result);
}
