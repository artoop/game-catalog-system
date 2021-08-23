package pds.gcs.service;

import java.util.List;

import pds.gcs.entity.Game;
import pds.gcs.entity.User;

public interface Notifier {
	public void notify(User user, List<Game> resources);
}
