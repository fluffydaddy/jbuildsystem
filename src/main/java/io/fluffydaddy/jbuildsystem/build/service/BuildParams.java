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

package io.fluffydaddy.jbuildsystem.build.service;

import io.fluffydaddy.jbuildsystem.build.BuildListener;
import io.fluffydaddy.jbuildsystem.build.BuildWrapper;
import io.fluffydaddy.jhelper.files.FileHandle;

/**
 * Build parameters.
 * <p>See also {@link BuildTask#doInBackground(BuildParams)}.</p>
 *
 * @param <R> The result after the build execution.
 */
public interface BuildParams<R> {

    /**
     * @return The user's home directory.
     */
    FileHandle getUserHome();

    /**
     * @return The path to the project directory.
     */
    FileHandle getProject();

    /**
     * @return The arguments passed to the builder.
     */
    String[] getArguments();

    /**
     * @return The listener for changes in the build system project.
     */
    BuildListener<R> getBuildListener();

    /**
     * @return The wrapper for the project builder.
     */
    BuildWrapper<R> getBuildWrapper();
}
