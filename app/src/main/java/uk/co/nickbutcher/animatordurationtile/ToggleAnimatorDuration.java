/*
 * Copyright 2016 Google Inc.
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

package uk.co.nickbutcher.animatordurationtile;

import android.service.quicksettings.TileService;

/**
 * A {@link TileService quick settings tile} for scaling animation durations. Toggles between 1x and
 * 5x animator duration scales.
 * <p>
 * Note that this requires a system level permission, so consumers <b>must</b> run this
 * <code>adb</code> command to use.
 * <p>
 * <code>adb shell pm grant uk.co.nickbutcher.animatordurationtile android.permission.WRITE_SECURE_SETTINGS</code>
 */
public class ToggleAnimatorDuration extends AnimatorDurationTileService {

    public ToggleAnimatorDuration() { }

    @Override
    public void onClick() {
        final float current = getAnimatorScale();
        final float target = current == 1f ? 5f : 1f;
        setAnimatorScale(target);
        updateTile();
    }

}
