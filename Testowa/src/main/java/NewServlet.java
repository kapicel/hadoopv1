/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.ToolRunner;
/**
 *
 * @author LUK
 */
@WebServlet(urlPatterns = {"/start"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
       Configuration configuration = new HadoopConfig();
        int tool =ToolRunner.run(configuration, new ToolRunnerClass(), new String[]{});
        PrintWriter out = response.getWriter();
	out.println(tool == 0 ? "Success" : "Error");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            PrintWriter out = response.getWriter();
            out.println("Success Error");
        } catch (Exception ex) {
                         PrintWriter out = response.getWriter();

            out.println(ex);
            out.println("Success Error");
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   
    
    
    
    public class MapForWordCount extends Mapper<LongWritable, Text, Text, IntWritable>{

@Override
public void map(LongWritable key, Text value, Mapper.Context con) throws IOException, InterruptedException

{
System.out.println("weeee");
String line = value.toString();

String[] words=line.split(",");

for(String word: words )

{
        System.out.println(word);
      Text outputKey = new Text(word.toUpperCase().trim());

  IntWritable outputValue = new IntWritable(1);

  con.write(outputKey, outputValue);

}

}
    }

public static class ReduceForWordCount extends Reducer<Text, IntWritable, Text, IntWritable>

{

public void reduce(Text word, Iterable<IntWritable> values, Reducer.Context con) throws IOException, InterruptedException

{

int sum = 0;

   for(IntWritable value : values)

   {

   sum += value.get();

   }

   con.write(word, new IntWritable(sum));

}

}
    }


