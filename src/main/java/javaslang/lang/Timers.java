/**    / \____  _    ______   _____ / \____   ____  _____
 *    /  \__  \/ \  / \__  \ /  __//  \__  \ /    \/ __  \   Javaslang
 *  _/  // _\  \  \/  / _\  \\_  \/  // _\  \  /\  \__/  /   Copyright 2014 Daniel Dietrich
 * /___/ \_____/\____/\_____/____/\___\_____/_/  \_/____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.lang;

import java.util.Timer;
import java.util.TimerTask;

public final class Timers {

	/**
	 * This class is not intendet to be instantiated.
	 */
	private Timers() {
		throw new AssertionError(Timers.class.getName() + " cannot be instantiated.");
	}

	/**
	 * Syntactic sugar, allows to call
	 * 
	 * <pre>
	 * <code>
	 * final Timer timer = Timers.schedule(() -&gt; println("hi"), 1000)
	 * </code>
	 * </pre>
	 * 
	 * instead of
	 * 
	 * <pre>
	 * <code>
	 * final Timer timer = new Timer();
	 * timer.schedule(new TimerTask() {
	 *     &#64;Override
	 *     public void run() {
	 *         println("hi");
	 *     }
	 * }, 1000);
	 * </code>
	 * </pre>
	 * 
	 * @param task A Runnable
	 * @param delay A delay in milliseconds
	 * @return A Timer
	 */
	public static Timer schedule(Runnable task, long delay) {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				task.run();
			}
		}, delay);
		return timer;
	}

}
