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

import java.io.File;

/**
 * This class serves as a wrapper for build systems.
 * It provides a convenient solution for switching between versions without unnecessary installations.
 * Use {@link #connect(String, String)} to connect to the project.
 *
 * @param <R> The result after the build execution.
 */
public interface BuildWrapper<R> {
    /**
     * Connects to the build system.
     *
     * @param userHome   The user's home directory.
     * @param projectDir The path to the project directory.
     * @return A new instance of the BuildSystem class.
     */
    BuildSystem<R> connect(File userHome, File projectDir);
    
    /**
     * Connects to the build system.
     *
     * @param userHome   The user's home directory.
     * @param projectDir The path to the project directory.
     * @return A new instance of the BuildSystem class.
     */
    BuildSystem<R> connect(String userHome, String projectDir);
    
    /**
     * Connects to the build system.
     *
     * @param userHome   The user's home directory.
     * @param projectDir The path to the project directory.
     * @return A new instance of the BuildSystem class.
     */
    BuildSystem<R> connect(FileHandle userHome, FileHandle projectDir);
}
