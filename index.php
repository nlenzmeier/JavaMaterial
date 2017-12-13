<?php include("include/loginheader.php"); ?>
<!DOCTYPE html>
<html lang="en">
  <head>
     <?php include("include/header.php"); ?>
  </head>
    
    <hr>
    
    <div class="container">
    <?php include("include/navbar.php"); ?>
        <hr>  
   <script src="css/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div id = "myCarousel" class = "carousel slide">
   
   <!-- Carousel indicators -->
   <ol class = "carousel-indicators">
      <li data-target = "#myCarousel" data-slide-to = "0" class = "active"></li>
      <li data-target = "#myCarousel" data-slide-to = "1"></li>
      <li data-target = "#myCarousel" data-slide-to = "2"></li>
   </ol>   
   
   <!-- Carousel items -->
   <div class = "carousel-inner">
      <div class = "item active">
         <img src = "images/img1.png" alt = "First slide">
      </div>
      
      <div class = "item">
         <img src = "images/img2.png" alt = "Second slide">
      </div>
      
      <div class = "item">
         <img src = "images/img3.png" alt = "Third slide">
      </div>
   </div>
   
   <!-- Carousel nav --> 
   <a class = "carousel-control left" href = "#myCarousel" data-slide = "prev">&lsaquo;</a>
   <a class = "carousel-control right" href = "#myCarousel" data-slide = "next">&rsaquo;</a>
</div> 

    <hr>
        
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>STL Lasers</h1>
          <h1>Tattoo and Hair Removal</h1>
          <p class="lead">Our office loves laser technology so much that we have 4 lasers.</p>

<p class = "lead">All consultations and treatments are performed by Lorna O'Young, M.D. She is a board certified gynecologist who has worked with cosmetic lasers since 2005. She practices gynecology Monday through Thursday 8:30am to 5:00pm. Laser consultations and treatments are scheduled during these hours as well as on Saturdays and evenings by appointment. Dr. O'Young's office is conveniently located in Copper Bend Office Park in Belleville, Illinois.
        </p>
        <a class="btn btn-large btn-success" href="contact.php">Contact Us!</a>
      </div>
      
      <hr>
      <?php include("include/footer.php"); ?>
  </body>
</html>
