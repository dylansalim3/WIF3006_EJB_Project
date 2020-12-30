<%-- 
    Document   : result
    Created on : 30-Dec-2020, 16:52:20
    Author     : Darren
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.darren.fitnesscalculator.models.* , javax.naming.*" %>
<%@page import="com.darren.fitnesscalculator.bmi.* , javax.naming.*" %>
<%@page import="com.darren.fitnesscalculator.calorie.* , javax.naming.*" %>
<%@page import="com.darren.fitnesscalculator.idealweight.* , javax.naming.*" %>

<%!
    private PersonalInfoRemote personalInfo = null;
    private ExerciseLevelRemote exerciseLevel = null;
    private IdealWeightRemote idealWeight = null;
    private BmiRemote bmiRemote = null;
    private CalorieCalculationRemote calorieCalculation = null;

    public void jspInit(){
        try{
            InitialContext ic = new InitialContext();
            personalInfo = (PersonalInfoRemote)ic.lookup(PersonalInfoRemote.class.getName());
            exerciseLevel = (ExerciseLevelRemote)ic.lookup(ExerciseLevelRemote.class.getName());
            idealWeight = (IdealWeightRemote)ic.lookup(IdealWeightRemote.class.getName());
            bmiRemote = (BmiRemote)ic.lookup(BmiRemote.class.getName());
            calorieCalculation = (CalorieCalculationRemote)ic.lookup(CalorieCalculationRemote.class.getName());
            
            System.out.println("All the beans loaded");
        }
        catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void jspDestroy(){
        personalInfo = null;
        exerciseLevel = null;
        idealWeight = null;
        bmiRemote = null;
        calorieCalculation = null;
    }
%>

<html> 
<head>
        <title>Result</title>
    </head>
    <body bgColor="lightBlue">
        <h1>Result</h1>
        <small>Result of your body assessment</small>
        <hr>
        <h2>BMI</h2>
        <hr>

<%
    try{
        personalInfo.setAge(Integer.parseInt(request.getParameter("age")));
        personalInfo.setHeight(Double.parseDouble(request.getParameter("height")));
        personalInfo.setWeight(Double.parseDouble(request.getParameter("weight")));
        personalInfo.setGender(request.getParameter("gender"));
        personalInfo.setBodyFat(Double.parseDouble(request.getParameter("bodyFat")));
        double height = personalInfo.getHeight();
        String exerciseChoice = request.getParameter("exerciseLevel");
        String formulaChoice = request.getParameter("formula");
        if(exerciseChoice != null){
            if(exerciseChoice.equalsIgnoreCase("LittleNoExercise")){
                personalInfo.setExerciseLevelId(0);
                exerciseLevel.setId(0);
                exerciseLevel.setExerciseLevel("Little to no exercise");
                exerciseLevel.setCounter(1.2);
            } 
            else if(exerciseChoice.equalsIgnoreCase("LightExercise")){
                personalInfo.setExerciseLevelId(1);
                exerciseLevel.setId(1);
                exerciseLevel.setExerciseLevel("Light Exercise (1-3 days per week)");
                exerciseLevel.setCounter(1.375);
            }
            else if(exerciseChoice.equalsIgnoreCase("ModerateExercise")){
                personalInfo.setExerciseLevelId(2);
                exerciseLevel.setId(2);
                exerciseLevel.setExerciseLevel("Moderate Exercise (3-5 days per week)");
                exerciseLevel.setCounter(1.55);
            }
            else if(exerciseChoice.equalsIgnoreCase("HeavyExercise")){
                personalInfo.setExerciseLevelId(3);
                exerciseLevel.setId(3);
                exerciseLevel.setExerciseLevel("Heavy exercise (6-7 days per week)");
                exerciseLevel.setCounter(1.725);
            }
            else if(exerciseChoice.equalsIgnoreCase("ExtremeExercise")){
                personalInfo.setExerciseLevelId(4);
                exerciseLevel.setId(4);
                exerciseLevel.setExerciseLevel("Very heavy exercise (twice per day, extra heavy workouts)");
                exerciseLevel.setCounter(1.9);
            }
        }
        
        if(formulaChoice != null){
            if(formulaChoice.equalsIgnoreCase("Mifflin-St Jeor Equation")){
                personalInfo.setCalorieFormula("Mifflin-St Jeor Equation");
            }
            else if(formulaChoice.equalsIgnoreCase("Revised Harris-Benedict Equation")){
                personalInfo.setCalorieFormula("Revised Harris-Benedict Equation");
            }
            else if(formulaChoice.equalsIgnoreCase("Katch-McArdle Formula")){
                personalInfo.setCalorieFormula("Katch-McArdle Formula");
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        calorieCalculation.calculateCalorieLevel(personalInfo.getGender(),personalInfo.getWeight(),personalInfo.getHeight(),personalInfo.getAge(),personalInfo.getBodyFat(),personalInfo.getCalorieFormula(),exerciseLevel.getCounter());
        double calculatedIdealWeight = idealWeight.calculateIdealWeight((personalInfo.getHeight()/100), personalInfo.getGender());
        String idealWeightToList = df.format(calculatedIdealWeight);
        double calculatedBMI = bmiRemote.getBMI(personalInfo.getWeight(),(personalInfo.getHeight()/100));
        String bmiToList = df.format(calculatedBMI);
        String bmiCategory = bmiRemote.getCategory(calculatedBMI);
        int maintainWeight = calorieCalculation.getCaloriesToMaintain();
        int mildWeightLoss = calorieCalculation.getCaloriesToMildWeightLoss();
        int weightLoss = calorieCalculation.getCaloriesToWeightLoss();
        int extremeWeightLoss = calorieCalculation.getCaloriesToExtremeWeightLoss();
        
        int mildWeightPercentage = (mildWeightLoss*100)/maintainWeight;
        int weightLossPercentage = (weightLoss*100)/maintainWeight;
        int extremeWeightLossPercentage = (extremeWeightLoss*100)/maintainWeight;
%>
   
    
        
        <p>Your BMI level is : <%= bmiToList%> </p> 
        <p>You are <%= bmiCategory%></p>
        
        <h2>Calorie</h2>
        <hr>
        <p>The results show a number of daily calorie estimates that can be used as a guideline for how much calories to consume
            each day to maintain, lose or gain weight at chosen rate.</p>
        <hr>
        <h3>Maintain Weight</h3>
        <p> <%= maintainWeight%>      <small>100%</small><br/>
            Calories/day
        </p>
        <hr>
        <h3>Mild Weight Loss</br><sub><small>0.25kg/week</small></sub></h3>
        
        <p> <%= mildWeightLoss%>      <small><%= mildWeightPercentage%>%</small><br/>
            Calories/day<br />
        </p>
        <hr>
        <h3>Weight Loss</br><sub><small>0.50kg/week</small></sub></h3>
        <p> <%= weightLoss%>      <small><%= weightLossPercentage%>%</small><br/>
            Calories/day<br/>
            
        </p>
        <hr>
        <h3>Extreme Weight Loss</br><sub><small>1kg/week</small></sub></h3>
        <p> <%= extremeWeightLoss%>      <small><%= extremeWeightLossPercentage%>%</small><br/>
            Calories/day<br/>
            
        </p>
        <hr>
        <p>Please consult a doctor when losing 1kg or more per week since it requires you to consume less than
            the minimum recommendation of 1500 calories per day.
        </p>
        
        
        <h2>Ideal Weight</h2>
        <hr>
        <p>Your ideal weight is: <%= idealWeightToList%></p> 
    

<%  
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
%>

</body>
</html>