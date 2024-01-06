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

import io.fluffydaddy.jbuildsystem.build.BuildSystem;
import io.fluffydaddy.jtasks.impl.TaskService;

/**
 * Task to be performed for a successful build.
 *
 * @param <R> The result after the build execution.
 */
public abstract class BuildTask<R> extends TaskService<R, BuildParams<R>> {
    /**
     * Task building the project.
     *
     * @param buildParams The build project parameters.
     */
    @Override
    public R doInBackground(BuildParams<R> buildParams) throws Exception {
        return taskBuild(
                buildParams.getBuildWrapper()
                        .connect(buildParams.getUserHome(), buildParams.getProject())
                        .useBuildListener(buildParams.getBuildListener())
                        .execute(buildParams.getArguments())
        );
    }

    /**
     * @param buildSystem The current build system.
     * @return The result of the execution.
     * @throws Exception All possible exceptions.
     */
    public abstract R taskBuild(BuildSystem<R> buildSystem) throws Exception;
}
