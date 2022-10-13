package com.daniele.project.revo;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyDemo
{
        final String DOMAIN = "http://short.com";
        /**
         *         Given as input a URL and a SEO keyword with a max length of 20 characters, chosen by the user, generate a SEO URL.
         //
                        Input:
         //        URL: http://looooong.com/somepath
         //        SEO keyword: MY-NEW-WS
         //        Output:
         //        URL: http://short.com/MY-NEW-WS
         //
         //        Input:
         //        URL: http://looooong.net/another/somepath
         //        SEO keyword: POTATO
         //        Output:
         //        URL: http://short.com/POTATO
         * @param url
         * @return
         */
        public String  method1(String url, String seoKey)
        {       if(seoKey.length()<=20)
                {
                        StringBuilder sb = new StringBuilder();
                        sb.append(DOMAIN).append("/").append(seoKey);
                        return sb.toString();
                } else 
                {
                   throw new IllegalArgumentException("Input validation error : SEO keyword exceeds the length .");
                }

        }


        /**
         * 2 - Random keyword generation
         *
         * Given a URL as input, generate a short URL with a path made of a random sequence of 4 alphanumeric characters.
         *
         * Example:
         *
         * Input:
         * URL: http://looooong.com/somepath
         * Output: http://short.com/ZfGd
         *
         * */
        public String method2(String inputUrl)
        {
                String seoKey =  getRandomSeoKey(4);
//                        getRandomSeoKey();
                StringBuilder sb = new StringBuilder();
                sb.append(DOMAIN).append("/").append(seoKey);
                return sb.toString();

        }

        private String getRandomSeoKey(int len)
        {
//          char randomChar = (char) (Math.random() * 36 /100)  ;
//          char randomChar = (char) (Math.random() * 36)  ;
            List<Character> charactersList =  Arrays.asList('0','1','2','3','a','b','c','D','E','F');
//            byte[] array = new byte[7]; // length is bounded by 7
//            new Random().nextBytes(array);
//            String generatedString = new String(array, Charset.forName("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<len;i++)
                sb.append(charactersList.get((int) (Math.random() * 10)));
            return sb.toString();
//            return generatedString;
        }

        private String genRandAlphaNumString(int len)
        {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = len;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
//                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();

//            System.out.println(generatedString);
            return  generatedString;
        }
}
