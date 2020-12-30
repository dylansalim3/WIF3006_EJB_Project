<%-- 
    Document   : form
    Created on : 30-Dec-2020, 16:08:23
    Author     : Darren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FitnessCalculator</title>
    </head>
    <body bgColor="lightblue">
        <h1>Enter your info</h1>
        <hr>
        
        <form action="result.jsp" method="POST">
            <p>Age(Between 15 - 80): <input type = "number" name="age" id="age" required></p>
            <p>Height (cm): <input type="number" name="height" id="height" required> </p>
            <p>Weight (Kg): <input type="number" name="weight" id="weight" required></p>
            <p>Select your Gender</p>
            <input type="radio" name="gender" value="male" checked>Male<br>
            <input type="radio" name="gender" value="female">Female<br>
            <p>Select Exercise Level: </p>
            <input type="radio" name="exerciseLevel" value="LittleNoExercise" checked>Little to no exercise<br>
            <input type="radio" name="exerciseLevel" value="LightExercise">Light Exercise (1-3 days per week)<br>
            <input type="radio" name="exerciseLevel" value="ModerateExercise">Moderate Exercise (3-5 days per week)<br>
            <input type="radio" name="exerciseLevel" value="HeavyExercise">Heavy exercise (6-7 days per week)<br>
            <input type="radio" name="exerciseLevel" value="ExtremeExercise">Very heavy exercise (twice per day, extra heavy workouts)<br>
            <p>BMR Estimation Formula</p>
            <input type="radio" name="formula" value="Mifflin-St Jeor Equation" checked>Mifflin-St Jeor Formula<br>
            <input type="radio" name="formula" value="Revised Harris-Benedict Equation">Revised Harris-Benedict Formula<br>
            <input type="radio" name="formula" value="Katch-McArdle Formula">Katch-McArdle Formula<br>
            <p>Body Fat(Percentage %):<input type="number" name="bodyFat" id="bodyFat" required></p>
            
            <p>
                <input type="submit" value="Submit">
            </p>
        </form>
        
        
    </body>
</html>
