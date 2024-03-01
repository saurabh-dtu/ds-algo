//Create a Resource Pool of objects, Basically you should implement a getResource and a releaseResource function. 

import java.util.LinkedList;
import java.util.List;

class ResourcePool<T> {
    private final List<T> availableResources;
    private final List<T> allocatedResources;

    public ResourcePool(List<T> resources) {
        this.availableResources = new LinkedList<>(resources);
        this.allocatedResources = new LinkedList<>();
    }

    public synchronized T getResource() throws InterruptedException {
        while (availableResources.isEmpty()) {
            // Wait until a resource becomes available
            wait();
        }

        T resource = availableResources.remove(0);
        allocatedResources.add(resource);

        return resource;
    }

    public synchronized void releaseResource(T resource) {
        if (allocatedResources.contains(resource)) {
            allocatedResources.remove(resource);
            availableResources.add(resource);

            // Notify waiting threads that a resource is available
            notify();
        } else {
            throw new IllegalArgumentException("Trying to release a resource that was not allocated from this pool.");
        }
    }
}

// Example usage with a Resource class
class Resource {
    private static int counter = 0;
    private final int resourceId;

    public Resource() {
        this.resourceId = counter++;
    }

    public int getResourceId() {
        return resourceId;
    }

    // Additional methods or properties specific to the Resource class
}

public class Main {
    public static void main(String[] args) {
        List<Resource> resourceList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            resourceList.add(new Resource());
        }

        ResourcePool<Resource> resourcePool = new ResourcePool<>(resourceList);

        // Thread 1
        new Thread(() -> {
            try {
                Resource resource = resourcePool.getResource();
                System.out.println("Thread 1 acquired resource with ID: " + resource.getResourceId());
                // Do some work with the resource
                Thread.sleep(1000);
                resourcePool.releaseResource(resource);
                System.out.println("Thread 1 released resource with ID: " + resource.getResourceId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Thread 2
        new Thread(() -> {
            try {
                Resource resource = resourcePool.getResource();
                System.out.println("Thread 2 acquired resource with ID: " + resource.getResourceId());
                // Do some work with the resource
                Thread.sleep(1000);
                resourcePool.releaseResource(resource);
                System.out.println("Thread 2 released resource with ID: " + resource.getResourceId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
