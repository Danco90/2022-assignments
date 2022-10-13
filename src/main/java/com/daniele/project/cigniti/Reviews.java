package com.daniele.project.cigniti;

import java.util.Objects;

public class Reviews
{
    private String reviewId;
    private String tags;
    private String topics;
    private String date;

    public Reviews(String reviewId, String tags, String topics, String date)
    {
        this.reviewId = reviewId;
        this.tags = tags;
        this.topics = topics;
        this.date = date;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviews reviews = (Reviews) o;
        return reviewId.equals(reviews.reviewId) && Objects.equals(tags, reviews.tags) && Objects.equals(topics, reviews.topics) && date.equals(reviews.date);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(reviewId, date);
    }

    @Override
    public String toString()
    {   String string = """
                {
                    "reviewId" : $reviewId ,
                    "tags"     : $tags ,
                    "topics"   : $topics , 
                    "date"     : $date 
                }
               """
               ;
        return string.replace("$reviewId", reviewId)
                .replace("$tags", tags)
                .replace("$topics", topics)
                .replace("$date", date);
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "reviewId='" + reviewId + '\'' +
//                ", tags='" + tags + '\'' +
//                ", topics='" + topics + '\'' +
//                ", date='" + date + '\'' +
//                '}';
//    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
