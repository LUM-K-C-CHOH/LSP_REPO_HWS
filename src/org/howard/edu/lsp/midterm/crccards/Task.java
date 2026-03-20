package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the Task Management System.
 * @author Lum Choh
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a Task with default status of OPEN.
     * @param taskId the unique task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /** @return the task ID */
    public String getTaskId() { return taskId; }

    /** @return the task description */
    public String getDescription() { return description; }

    /** @return the task status */
    public String getStatus() { return status; }

    /**
     * Sets the task status.
     * @param status the new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || 
            status.equals("IN_PROGRESS") || 
            status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /** @return formatted string representation of the task */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}