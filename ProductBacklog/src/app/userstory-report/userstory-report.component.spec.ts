import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserstoryReportComponent } from './userstory-report.component';

describe('UserstoryReportComponent', () => {
  let component: UserstoryReportComponent;
  let fixture: ComponentFixture<UserstoryReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserstoryReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserstoryReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
