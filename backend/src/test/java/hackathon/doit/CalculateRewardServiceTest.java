package hackathon.doit;

import hackathon.doit.dto.Reward;
import hackathon.doit.model.Account;
import hackathon.doit.model.AccountTask;
import hackathon.doit.service.CalculateRewardService;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CalculateRewardServiceTest {

	@Test
	public void test() {
		// setup
		AccountTask task1 = new AccountTask();
		task1.setDone(true);
		task1.setImportance(5);
		
		AccountTask task2 = new AccountTask();
		task2.setDone(true);
		task2.setImportance(4);
		
		AccountTask task3 = new AccountTask();
		task3.setDone(false);
		task3.setImportance(3);
		
		AccountTask task4 = new AccountTask();
		task4.setDone(false);
		task4.setImportance(2);
		
		AccountTask task5 = new AccountTask();
		task5.setDone(false);
		task5.setImportance(1);
		
		List<AccountTask> tasks = Arrays.asList(task1, task2, task3, task4, task5);
		
		Account account = new Account();
		account.setTasks(tasks);
		
		// execute
		CalculateRewardService calRewardService = new CalculateRewardService();
		Reward reward = calRewardService.getRewardForAccount(account);
		
		// verify
		Assert.assertEquals("c", reward.getImgSource());
		Assert.assertEquals("3", reward.getMessage());
	}

}
