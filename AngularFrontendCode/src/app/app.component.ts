import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './component/header/header.component';
import { CoursesComponent } from './component/courses/courses.component';
import { RegistrationComponent } from './component/registration/registration.component';
import { CourseComponent } from './component/courses/course/course.component';
import { EnquiryComponent } from './component/enquiry/enquiry.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HeaderComponent,CoursesComponent,RegistrationComponent,CourseComponent,EnquiryComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'my-app';
}
