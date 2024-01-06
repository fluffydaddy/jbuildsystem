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

import io.fluffydaddy.jhelper.files.FileHandle;

/**
 * System for building projects. See also {@link #execute(String...)}.
 * <p>
 * Acts as a project builder, compiler, dependency loader, as well as a linker and packager.
 * </p>
 *
 * @param <R> The result after the build execution.
 */
public interface BuildSystem<R> {
    /**
     * @return The name of the build system.
     */
    String getName();

    /**
     * @return The display name of the build system.
     */
    String getDisplayName();

    /**
     * Installs the build system in {@code userHome} using the project configuration in {@code
     * projectDir}.
     *
     * @param userHome   The user's home directory.
     * @param projectDir The path to the project directory.
     * @return The path to the installed build system.
     */
    FileHandle install(FileHandle userHome, FileHandle projectDir);

    /**
     * Sets a listener for build system events.
     *
     * @param buildListener The listener for build system events.
     * @return Returns the current build system.
     */
    BuildSystem<R> useBuildListener(BuildListener<R> buildListener);

    /**
     * Executes the build system with the specified arguments {@code args}.
     *
     * @param args The arguments passed to the build system.
     * @return Returns the current build system.
     */
    BuildSystem<R> execute(String... args) throws Exception;
}
