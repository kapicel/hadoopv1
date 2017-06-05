/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUK
 */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;


public class HadoopConfig extends Configuration{

    public HadoopConfig() {
        set("fs.hdfs.impl", DistributedFileSystem.class.getName());
        set("fs.file.impl", LocalFileSystem.class.getName());
        
        set("mapreduce.jobtracker.address", "192.168.5.10:54311");
        set("mapreduce.framework.name", "yarn");
        
        set("dfs.replication", "2");
        
        set("fs.defaultFS", "hdfs://192.168.5.10:9000");
        
        set("yarn.resourcemanager.hostname", "192.168.5.10");
        set("yarn.nodemanager.aux-services", "mapreduce_shuffle");

        set("mapreduce.app-submission.cross-platform", "true");
    }
    

}