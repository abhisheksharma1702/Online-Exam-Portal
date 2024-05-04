import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chatbot',
  templateUrl: './chatbot.component.html',
  styleUrls: ['./chatbot.component.css']
})
export class ChatbotComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.messages.push("Support Assistant: Hi I'm your support chatbot. How can I help you?");
  }

  messages: string[]= [];
  userInput: any ='';
  userMessage: string[]= [];
  i:number=0;

  processUserInput(userInput: string): string{
      if(userInput.toLowerCase().includes('hello')){
        return 'Hello! How Can I assist you?';
      } else 
      if(userInput.toLowerCase().includes('hi')){
        return 'Hi! How Can I assist you?';
      } else if(userInput.toLowerCase().includes('error')){
        return 'Your exam is not going smooth? Yes/No';
      } else if(userInput.toLowerCase().includes('loading')){
        return 'Your exam is not going smooth? Yes/No';
      }else if(userInput.toLowerCase().includes('not working')){
        return 'Your exam is not going smooth? Yes/No';
      }else if(userInput.toLowerCase().includes('yes')){
        return 'Type RES to reschedule you exam'
      }else if(userInput.toLowerCase().includes('res')){
        return 'Your exam has been reschedule..check your mail for updated date and time...Thanks for your patience!!'
      } else if(userInput.toLowerCase().includes('thanks')){
        return 'Thank you..For more assistance contact us through mail from help portal';
      } else if(userInput.toLowerCase().includes('thank you')){
        return 'Thank you..For more assistance contact us through mail from help portal';
      } else if(userInput.toLowerCase().includes('thank')){
        return 'Thank you..For more assistance contact us through mail from help portal';
      } else if(userInput.toLowerCase().includes('hank')){
        return 'Thank you..For more assistance contact us through mail from help portal';
      }else{
        return 'I am sorry, I didnt understand your query..For more assistance mail us through help portal '
      }
  }


  sendMessage(){
    
    console.log(this.userInput);
    if(this.userInput.trim()!==''){
      this.messages.push("user: "+ this.userInput);
      const response= this.processUserInput(this.userInput);
      this.messages.push("Support Assistant: "+ response);
      this.userInput='';

    }
  }

  logic(){
    var datetime = new Date().toDateString();
    return datetime;
  }

}
