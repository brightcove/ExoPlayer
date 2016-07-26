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

import java.util.Collections;
import java.util.List;

/**
 * Represents an HLS master playlist.
 */
public final class HlsMasterPlaylist extends HlsPlaylist {

  public final List<Variant> variants;
  public final List<Variant> closedCaptions;
  public final List<Variant> audios;
  public final List<Variant> videos;
  public final List<Variant> subtitles;
  public final String muxedAudioLanguage;
  public final String muxedCaptionLanguage;

  public HlsMasterPlaylist(String baseUri, List<Variant> variants,
      List<Variant> subtitles, List<Variant> closedCaptions,
      List<Variant> audios, List<Variant> videos,
      String muxedAudioLanguage, String muxedCaptionLanguage) {
    super(baseUri, HlsPlaylist.TYPE_MASTER);
    this.variants = Collections.unmodifiableList(variants);
    this.subtitles = Collections.unmodifiableList(subtitles);
    this.closedCaptions = Collections.unmodifiableList(closedCaptions);
    this.audios = Collections.unmodifiableList(audios);
    this.videos = Collections.unmodifiableList(videos);
    this.muxedAudioLanguage = muxedAudioLanguage;
    this.muxedCaptionLanguage = muxedCaptionLanguage;

    for (Variant variant : variants) {
      for (Variant subtitle : subtitles) {
        if (variant.subtitlesGroup != null && subtitle.groupID != null &&
            variant.subtitlesGroup.equals(subtitle.groupID)) {
          variant.subtitles.add(subtitle);
        }
      }

      for (Variant closedCaption : closedCaptions) {
        if (variant.closedCaptionsGroup != null && closedCaption.groupID != null &&
            variant.closedCaptionsGroup.equals(closedCaption.groupID)) {
	    variant.closedCaptions.add(closedCaption);
        }
      }

      for (Variant audiosVariant : audios) {
        if (variant.audioGroup != null && audiosVariant.groupID != null &&
            variant.audioGroup.equals(audiosVariant.groupID)) {
          variant.audios.add(audiosVariant);
        }
      }

      for (Variant videosVariant : videos) {
        if (variant.videoGroup != null && videosVariant.groupID != null &&
            variant.videoGroup.equals(videosVariant.groupID)) {
          variant.videos.add(videosVariant);
        }
      }
    }
  }

  public Variant getDefaultAlternateAudio() {
    Variant result = null;

    for (Variant variant : audios) {
      if (variant.isDefault()) {
        result = variant;
        break;
      }
    }

    return result;
  }
}
