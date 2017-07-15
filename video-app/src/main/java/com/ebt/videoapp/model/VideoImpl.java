package com.ebt.videoapp.model;

import com.ebt.common.Video;
import com.ebt.common.VideoCategory;

/**
 * Объект видео.
 *
 * @author EastBanc Technologies (http://eastbanctech.ru/)
 */
public class VideoImpl implements Video {

    private String id;

    private String title;

    private String url;

    private Double rating;

    private VideoCategory category;

    private String source;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public VideoCategory getCategory() {
        return category;
    }

    public void setCategory(VideoCategory category) {
        this.category = category;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
