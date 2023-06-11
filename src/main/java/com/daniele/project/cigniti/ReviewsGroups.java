package com.daniele.project.cigniti;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReviewsGroups
{
    public void groupBy_Date_And_TopicsCount(List<Reviews> reviews)
    {

    }        

    public void groupBy_Date(List<Reviews> reviews)
    {
     /*   TreeMap<String, List<String>> multipleFiledsMap =
                reviews.stream()
                        .collect(
                                Collectors.groupingBy(Reviews::getDate,
                                TreeMap::new,
                                Collectors.toList()));
                                */
    }

    public record TopicRecord(String topicName, String topicCount) {

        @Override
        public String toString()
        {   String string = """
                {
                    "topicName": $topicName ,
                    "topicCount": $topicCount 
                }
               """
                ;
            return string.replace("$topicName", topicName)
                    .replace("$topicCount", topicCount)
                    ;
        }
    }

    public static void main(String[] args)
    {
        List<Reviews> reviewsList= new ArrayList<>();
        reviewsList = Stream.of(new Reviews("1", "[\"group1\",\"group2\"]", "[\"air\",\"Speed\"]", "2021-01-01 05:32:44"),
                        new Reviews("2", "[\"group1\"]", "[\"Air\",\"quality\"]", "2021-01-07 09:32:44"),
                        new Reviews("3", "[\"group3\"]", "[\"air\",\"blades\"]", "2021-01-07 01:32:24"))
                .collect(Collectors.toList());

        System.out.println(reviewsList);

//        Map<String, List<TopicRecord>> map =
//          Map<String, List<String>> map = reviewsList.stream().collect(
//                  Collectors.groupingBy(
//                          r -> r.getDate() ,
//                          Collectors.mapping( r2 -> r2.getTopics(),
////                                  Collectors.toList(),
//                                  Collectors.counting()
//                          )));
        Map<String, Map<String, Long>> multipleFiledsMap =
                reviewsList.stream()
                .collect(
                        Collectors.groupingBy( Reviews::getDate,
                        //Collectors.groupingBy( r -> r.getDate().substring(0,10),
                                Collectors.groupingBy( Reviews::getTopics,
//                                    Collectors.mapping( r -> r.replace("[\"").replace("\"]").split("\",\""), Collectors.counting())
//                                        ,
                                        Collectors.mapping( r -> r.getTopics().replace("[\"","").replace("\"]","")
                                                .split("\",\""),
                                                        Collectors.flatMapping(l -> Arrays.stream(l),
//                                                        Collectors.toList()

                                                        Collectors.counting())
                                               )
//                          Collectors.groupingBy( Reviews::getTopics,
//                                   Collectors.counting()
                                )
                        )
                );

        record ReviewTopics(String date, List<String> topicsList) {
            @Override
            public String toString()
            {   String string = """
                
                    "date": "$date" ,
                    "topicsList": "$topicsList"
                
               """
                    ;
                return string.replace("$date", date)
                        .replace("$topicsList", topicsList.toString());
            }
        };



        Map<Object, java.util.List<com.daniele.project.cigniti.Reviews>> out =
                reviewsList.stream()
                        .collect(
                                Collectors.groupingBy( review -> new ReviewTopics(review.getDate(), Arrays.asList(
                                        review.getTopics().replace("[\"","").replace("\"]","")
                                                .split("\",\"")) )
                                )
                        );

        //[{"date":"2021-01-01","topicsList":[{"topicName":"air","topicCount":3},{"topicName":"speed","topicCount":1}],{},{}]
        System.out.println("\ntopic output format:"+ multipleFiledsMap);
        System.out.println("\ntopic out  improved:"+ out);
        
    }

    class Topic {
        private String topicName;
        private int topicCount ;

        public Topic(String topicName, int topicCount) {  
            this.topicName = topicName;
            this.topicCount = topicCount;
        }

        public String getTopicName() {
            return topicName;
        }
        public int getTopicCount() {
            return topicCount;
        }
    }

    private String date;
    private List<Topic> topicsList;

    public ReviewsGroups(String date, List<Topic> topicsList) {
        this.date = date;
        this.topicsList = new ArrayList<>(topicsList);
    }

    public String getTDate() {
        return date;
    }
    public List<Topic> getTopicsList() {
        return topicsList;
    }

}
