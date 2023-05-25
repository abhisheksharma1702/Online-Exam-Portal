// // import { NgModule } from '@angular/core';
// // import { RouterModule, Routes } from '@angular/router';

// // const routes: Routes = [];

// // @NgModule({
// //   imports: [RouterModule.forRoot(routes)],
// //   exports: [RouterModule]
// // })
// // export class AppRoutingModule { }
// import { Component, NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';
// import { AboutUsComponent } from './about-us/about-us.component';
// import { AdminLoginComponent } from './admin-login/admin-login.component';
// import { ExamUiComponent } from './exam-ui/exam-ui.component';
// import { HomeComponent } from './home/home.component';
// import { MenuBarComponent } from './menu-bar/menu-bar.component';
// import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
// import { ExamSelectionComponent } from './exam-selection/exam-selection.component';
// import { UserLoginComponent } from './user-login/user-login.component';
// import { UserRegistrationComponent } from './user-registration/user-registration.component';
// import { ReportSuccessComponent } from './report-success/report-success.component';
// import { AddQuestionComponent } from './add-question/add-question.component';
// import { RemoveQuestionComponent } from './remove-question/remove-question.component';
// import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
// import { Report } from './appmodel/report';
// import { ReportComponent } from './report/report.component';
// import { InstructionsComponent } from './instructions/instructions.component';

// const routes: Routes = [
//   {path:'', component:HomeComponent},
//   {path:'user_registration' ,component:UserRegistrationComponent},
//   {path:'user_login' , component:UserLoginComponent},
//   {path:'admin_login' ,component:AdminLoginComponent},
//   {path:'exam_ui', component:ExamUiComponent},
//   {path:'userDashboard',component:UserDashboardComponent},
//   {path:'userNavBar',component:MenuBarComponent},
//   {path:'aboutUs',component:AboutUsComponent},
//   {path:'exam_selection',component:ExamSelectionComponent },
//   {path:'report_success',component:ReportSuccessComponent},
//   {path:'add_question', component:AddQuestionComponent},
//   {path:'remove_question', component:RemoveQuestionComponent},
//   {path:'admin_dashboard', component:AdminDashboardComponent},
//   {path:'user_report', component:ReportComponent},
//   {path:'exam_instructions',component:InstructionsComponent}
// ];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }


import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomeComponent } from './home/home.component';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { ExamSelectionComponent } from './exam-selection/exam-selection.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { ReportSuccessComponent } from './report-success/report-success.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { RemoveQuestionComponent } from './remove-question/remove-question.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ReportComponent } from './report/report.component';
import { InstructionsComponent } from './instructions/instructions.component';
import { ExamcomComponent } from './examcom/examcom.component';
import { ProfileComponent } from './profile/profile.component';
// import { SampleChangesGuard } from './sample-changes-guard'
// import {SampleComponentCanDeactivate} from './sample-component-can-deactivate'
// import { DeactivateGuard } from './deactivate-guard';
import { CandidateExamLoginComponent } from './candidate-exam-login/candidate-exam-login.component';
import { ExamUIComponent } from './exam-ui/exam-ui.component';
import { ChatbotComponent } from './chatbot/chatbot.component';
const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'user_registration' ,component:UserRegistrationComponent},
  {path:'user_login' , component:UserLoginComponent},
  {path:'admin_login' ,component:AdminLoginComponent},
  {path:'exam_ui/:courseId/:levelId',component:ExamUIComponent},
  {path:'userDashboard',component:UserDashboardComponent},
  {path:'userNavBar',component:MenuBarComponent},
  {path:'aboutUs',component:AboutUsComponent},
  {path:'exam_selection',component:ExamSelectionComponent },
  {path:'report_success',component:ReportSuccessComponent},
  {path:'add_question', component:AddQuestionComponent},
  {path:'remove_question', component:RemoveQuestionComponent},
  {path:'admin_dashboard', component:AdminDashboardComponent},
  {path:'user_report', component:ReportComponent},
  {path:'exam_instructions/:courseId/:levelId',component:InstructionsComponent},
  {path:'register', component:ExamcomComponent},
  {path:'candidate_exam_login/:courseId/:levelId/:questionsize', component:CandidateExamLoginComponent},
  {path:'profile', component:ProfileComponent},
  {path: 'chatbot', component:ChatbotComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

