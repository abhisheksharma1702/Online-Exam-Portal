import { Injectable } from "@angular/core";
import { RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";

@Injectable()
export class DeactivateGuard {
  constructor() { }

  canActivate(state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return confirm("Form is not submitted");
  }
}
