/**
 * 
 */
package com.diycomputerscience.resourcelist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pshah
 *
 */
public class JDBCDataFacadeImpl implements IDataFacade {

	@Override
	public Topic fetchTopic(long topicId) throws DataException {
		Topic topic = new Topic("Java", "java", "Java description");
		return topic;
	}
	
	@Override
	public Topic fetchTopicBySlug(String slug) throws DataException {
		Topic topic = new Topic("Java", "java", "Java description");
		return topic;
	}

	@Override
	public List<Topic> fetchAllTopics() throws DataException {
		List<Topic> topics = new ArrayList<Topic>();
		topics.add(new Topic("Java", "java", "Java desc"));
		topics.add(new Topic("Python", "python", "Python desc"));
		return topics;
	}

	@Override
	public void addTopic(Topic topic) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTopic(long topicId) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTopic(Topic topic) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fetchResource(long resourceId) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Resource> fetchAllResources() throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> fetchAllResourcesByTopic(long topicId)
												throws DataException {
		String slug = "java";
		Topic topic = new Topic("Java", "java", "Java Description");
		topic.setId(topicId);
		//create a resource type model object to be used in instantiating a Resource
		ResourceType resourceTypeBlogPost = new ResourceType("blog", "Blog Post");
		//create a List to hold multiple resources... returned by the mock data facade
		List<Resource> resources = new ArrayList<Resource>();
		//create the topics our resources will be associated with
		List<Topic> topicsForResources = new ArrayList<Topic>();
		topicsForResources.add(topic);
		//create resources
		Resource javaBlog1 = new Resource("Java generics", "http://blogs.java.com/bloch/generics.html", "no comments", topicsForResources, resourceTypeBlogPost);
		Resource javaBlog2 = new Resource("Java annotations", "http://blogs.java.com/bloch/annotations.html", "no comments", topicsForResources, resourceTypeBlogPost);
		//add resources to the list
		resources.add(javaBlog1);
		resources.add(javaBlog2);
		return resources;
	}

	@Override
	public void addResource(Resource resource) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResource(long resourceId) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResource(Resource resource) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fetchResourceType(long resourceTypeId) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Topic> fetchAllResourceTypes() throws DataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addResourceType(ResourceType resourceType) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResourceType(long resourceTypeId) throws DataException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResourceType(ResourceType resourceType)
			throws DataException {
		// TODO Auto-generated method stub
		
	}

}
