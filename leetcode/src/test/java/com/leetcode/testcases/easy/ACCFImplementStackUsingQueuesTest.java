package com.leetcode.testcases.easy;

import com.leetcode.problems.easy.ACCFImplementStackUsingQueues;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ACCFImplementStackUsingQueuesTest {

    ACCFImplementStackUsingQueues main = new ACCFImplementStackUsingQueues();

    @Test
    public void test1() {
        main = new ACCFImplementStackUsingQueues();
        main.push(1);
        main.push(2);
        assertEquals(2, main.top());
        assertEquals(2, main.pop());
        assertFalse(main.empty());
    }

}