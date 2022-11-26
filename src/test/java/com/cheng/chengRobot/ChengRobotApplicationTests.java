package com.cheng.chengRobot;

import com.cheng.chengRobot.service.PlaygroundGameService;
import com.squareup.okhttp.*;
import net.mamoe.mirai.internal.deps.okhttp3.FormBody;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;


@SpringBootTest
class ChengRobotApplicationTests
{

    //    @Autowired
    private PlaygroundGameService service;

    @Test
    public void test1() throws IOException
    {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestbody = RequestBody.create(MediaType.parse("application/json")
                , "{\n" +
                        "  \"model\": \"text-davinci-003\",\n" +
                        "  \"prompt\": \"你好啊，你在做什么\",\n" +
                        "  \"temperature\": 1,\n" +
                        "  \"max_tokens\": 100,\n" +
                        "  \"top_p\": 1,\n" +
                        "  \"frequency_penalty\": 0.0,\n" +
                        "  \"presence_penalty\": 0.0\n" +
                        "}");
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/completions")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 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")
                .post(requestbody)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Test
    public void test2()
    {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.remove());
        queue.add(6);
        queue.forEach(new Consumer()
        {
            @Override
            public void accept(Object o)
            {
                System.out.println(o);
            }
        });

    }
}
