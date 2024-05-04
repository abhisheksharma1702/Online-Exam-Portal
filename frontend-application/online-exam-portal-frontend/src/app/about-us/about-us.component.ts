import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContatctServiceService } from '../service/contatct-service.service';
import { SignedService } from '../service/signed.service';
import { ContactDetails } from './contact-details';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {

  constructor(private router:Router, private ser: ContatctServiceService, private signedService: SignedService) { }

  contact: ContactDetails = new ContactDetails();

  user: any;

  ngOnInit(): void {
    this.signedService.getCurrentUser().subscribe(data => {
      console.log(data);
          this.user=data;
          this.contact.full_name = this.user.full_name;
          this.contact.email = this.user.email;
          console.log(this.contact.full_name + " " + this.contact.email);
    })
  }

  async contactSupport(){
    console.log("Inside method");

    if(this.contact.full_name==null || this.contact.email==null || this.contact.message==null){
      Swal.fire({
        position: 'top-right',
        icon: 'warning',
        title: 'All fields mandatory',
        showConfirmButton: false,
        timer: 1500
      })
    }
    else{
      this.signedService.contactSupport(this.contact).subscribe();
    Swal.fire({
      position: 'top-right',
      icon: 'success',
      title: 'ticket raised on your behalf..Check your mail for our response',
      showConfirmButton: true,
      // timer: 2500
    })
    this.router.navigate(['']);
    } 
  }
}
