package hackathon.doit.service;

import hackathon.doit.dto.Reward;
import hackathon.doit.model.Account;
import hackathon.doit.model.AccountTask;
import hackathon.doit.model.Achievement;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ariel-Laptop
 *
 */
public class CalculateRewardService {
	
	public CalculateRewardService() {
		
	}
	
	public Reward getRewardForAccount(Account account) {
		List<AccountTask> tasks = account.getTasks();
		
		int sumImportance = 0;
		int doneTasksImportance = 0;
		
		for (AccountTask accountTask : tasks) {
			sumImportance += accountTask.getImportance();
			
			if (accountTask.isDone()) {
				doneTasksImportance += accountTask.getImportance();
			}
		}
		
		if (doneTasksImportance > 0 && doneTasksImportance <= (sumImportance / 4)) {
			return getAchievement(account, "a", "1");
		} else if (doneTasksImportance > (sumImportance / 4) && doneTasksImportance <= (sumImportance / 2)) {
			return getAchievement(account, "b", "2");
		} else if (doneTasksImportance > (sumImportance / 2) && doneTasksImportance <= (sumImportance / 2) + (sumImportance / 4)) {
			return getAchievement(account, "c", "3");
		} else if (doneTasksImportance > (sumImportance / 2) + (sumImportance / 4) && doneTasksImportance < sumImportance - 1) {
			return getAchievement(account, "d", "4");
		} else if (doneTasksImportance == sumImportance) {
			return getAchievement(account, "e", "5");
		}
		
		// should never get here
		return null;
	}

	private Reward getAchievement(Account account, String imgSource, String message) {
		Reward reward = new Reward(imgSource, message);
		
		Achievement achievement = new Achievement();
		achievement.setName(reward.getMessage());
		
		if (account.getAchievements() == null || account.getAchievements().size() == 0) {
			List<Achievement> achievements = new ArrayList<>();
			achievements.add(achievement);
			
			account.setAchievements(achievements);
		} else {
			account.getAchievements().add(achievement);
		}
		
		return reward;
	}
}
