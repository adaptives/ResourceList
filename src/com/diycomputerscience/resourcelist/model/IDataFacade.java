/**
 * 
 */
package com.diycomputerscience.resourcelist.model;

import java.util.List;


/**
 * @author pshah
 *
 */
public interface IDataFacade {
	
	public Topic fetchTopic(long topicId) throws DataException;
	public Topic fetchTopicBySlug(String slug) throws DataException;
	public List<Topic> fetchAllTopics() throws DataException;
	public void addTopic(Topic topic) throws DataException;
	public void deleteTopic(long topicId) throws DataException;
	public void updateTopic(Topic topic) throws DataException;
	
	public void fetchResource(long resourceId) throws DataException;
	public List<Resource> fetchAllResources() throws DataException;
	public List<Resource> fetchAllResourcesByTopic(long topicId) throws DataException;
	public void addResource(Resource resource) throws DataException;
	public void deleteResource(long resourceId) throws DataException;
	public void updateResource(Resource resource) throws DataException;
	
	public void fetchResourceType(long resourceTypeId) throws DataException;
	public List<Topic> fetchAllResourceTypes() throws DataException;
	public void addResourceType(ResourceType resourceType) throws DataException;
	public void deleteResourceType(long resourceTypeId) throws DataException;
	public void updateResourceType(ResourceType resourceType) throws DataException;
	
}
