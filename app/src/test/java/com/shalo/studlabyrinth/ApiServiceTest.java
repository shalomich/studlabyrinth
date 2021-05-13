package com.shalo.studlabyrinth;

import com.google.android.gms.common.api.Api;
import com.shalo.studlabyrinth.services.ApiService;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ApiServiceTest {
    @Test
    public void addition_isCorrect() {
        ApiService service = new ApiService();

        assertEquals(6, service.getMaps().size());
    }
}