// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   title = 'exam_portal';
// }


import { Component,OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Online Exam Portal';

  sessionUser : any= sessionStorage.getItem("userId");
  constructor(){
    
  }
  ngOnInit(): void {
    console.log(this.sessionUser);
  }
  
  logout() {
    sessionStorage.clear();
  }
  
  
}
