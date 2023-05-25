import { CanDeactivate } from "@angular/router";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface SampleComponentCanDeactivate {
  SamplecanDeactivate: () => boolean | Observable<boolean>;
}

@Injectable()
export class SampleChangesGuard implements CanDeactivate<SampleComponentCanDeactivate> {
  constructor() {

  }

  canDeactivate(
    component: SampleComponentCanDeactivate
  ): boolean | Observable<boolean> {

      return component.SamplecanDeactivate()
        ? true
        : confirm(
            "WARNING: You have unsaved changes. Press Cancel to go back and save these changes, or OK to lose these changes."
          );
  }
}
