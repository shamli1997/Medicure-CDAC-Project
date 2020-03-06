import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {Router,RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DoctorProfileComponent } from './doctor-profile/doctor-profile.component';
import { AppointmentsceduleComponent } from './appointmentscedule/appointmentscedule.component';
import { PatientscheduleComponent } from './patientschedule/patientschedule.component';

import { TestreportComponent } from './testreport/testreport.component';
import { DoctorboardComponent } from './doctorboard/doctorboard.component';
import { PatienthistoryComponent } from './patienthistory/patienthistory.component';
import { AdminComponent } from './admin/admin.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { DeleteComponent } from './delete/delete.component';
import { PatientdashboardComponent } from './patientdashboard/patientdashboard.component';
import { DoctorlistComponent } from './doctorlist/doctorlist.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { DocloginComponent } from './doclogin/doclogin.component';
import { AdminDoctorsComponent } from './admin-doctors/admin-doctors.component';
import { UpdateDoctComponent } from './update-doct/update-doct.component';
import { ForgotComponent } from './forgot/forgot.component';
import { OtpComponent } from './otp/otp.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DoctorProfileComponent,
    AppointmentsceduleComponent,
    PatientscheduleComponent,
    
    TestreportComponent,
    
    DoctorboardComponent,
    
    PatienthistoryComponent,
    
    AdminComponent,
    
    AdddoctorComponent,
    
    DeleteComponent,
    
    PatientdashboardComponent,
    
    DoctorlistComponent,
    
    EditprofileComponent,
    
    RegisterComponent,

    LoginComponent,

    DocloginComponent,

    AdminDoctorsComponent,

    UpdateDoctComponent,

    ForgotComponent,

    OtpComponent,

    ChangepasswordComponent,

    AboutusComponent,

    ContactusComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path:"home",component:HomeComponent},
      {path:"doctorprofile/:doctorId",component:DoctorProfileComponent},
      {path:"appointment",component:AppointmentsceduleComponent},
      {path:"patientschedule",component:PatientscheduleComponent},
      {path:"testreport",component:TestreportComponent},
      {path:"doctordashboard",component:DoctorboardComponent},
      {path:"patienthistory",component:PatienthistoryComponent},
      {path:"admin",component:AdminComponent},
      {path:"add",component:AdddoctorComponent},
      {path:"delete",component:DeleteComponent},
      {path:"patientdashboard",component:PatientdashboardComponent},
      {path:"doctorlist",component:DoctorlistComponent},
      {path:"editprofile",component:EditprofileComponent},
      {path:"register",component:RegisterComponent},
      {path:"login",component:LoginComponent},
      {path:"doclogin",component:DocloginComponent},
      {path:"admindoc",component:AdminDoctorsComponent},
      {path:"updateDoct",component:UpdateDoctComponent},
      {path:"forget",component:ForgotComponent},
      {path:"change",component:ChangepasswordComponent},
      {path:"otp",component:OtpComponent},
      {path:"about",component:AboutusComponent},
      {path:"contact",component:ContactusComponent},
      {path:"",component:HomeComponent}

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
