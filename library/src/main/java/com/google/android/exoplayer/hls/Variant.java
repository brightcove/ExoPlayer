/*
 * Copyright (C) 2014 The Android Open Source Project
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
package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.FormatWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Variant stream reference.
 */
public final class Variant implements FormatWrapper {

  public final String url;
  public final Format format;
  public final String audioGroup;
  public final String videoGroup;
  public final String closedCaptionsGroup;
  public final String subtitlesGroup;
  public boolean isDefault;
  public String groupID;

  public final List<Variant> subtitles = new ArrayList<Variant>();
  public final List<Variant> closedCaptions = new ArrayList<Variant>();
  public final List<Variant> audios = new ArrayList<Variant>();
  public final List<Variant> videos = new ArrayList<Variant>();

  public Variant(String url, Format format) {
      this(url, format, null, false);
  }

  public Variant(String url, Format format, String groupID, boolean isDefault) {
    this(url, format, null, null, null, null);
    this.isDefault = isDefault;
    this.groupID = groupID;
  }

  public Variant(String url, Format format, String videoGroup, String audioGroup, String subtitlesGroup, String closedCaptionsGroup) {
    this.url = url;
    this.format = format;
    this.videoGroup = videoGroup;
    this.audioGroup = audioGroup;
    this.closedCaptionsGroup = closedCaptionsGroup;
    this.subtitlesGroup = subtitlesGroup;
  }

  @Override
  public Format getFormat() {
    return format;
  }

  public boolean isDefault() {
    return isDefault;
  }
}
